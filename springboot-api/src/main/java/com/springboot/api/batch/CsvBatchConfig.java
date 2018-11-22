package com.springboot.api.batch;

import com.springboot.api.domain.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author 章辉勇
 * @创建时间 2018年11月20日
 * @描述: Batch测试配置类
 **/
//@Configuration
/**
 * 开启批处理的支持
 * */
@EnableBatchProcessing
public class CsvBatchConfig {

    @Bean
    public ItemReader<Person> reader() throws Exception {
        // ①使用FlatFileltemReader读取文件。
        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
        // ②使用FlatFileltemReader的 setResource方法设置csv文件的路径。
        reader.setResource(new ClassPathResource("people.csv"));
        //③在此处对cvs文件的数据和领域模型类做对应映射。
        reader.setLineMapper(new DefaultLineMapper<Person>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"id", "name", "age", "address"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                setTargetType(Person.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        //①使用我们自己定义的ItemProcessor的实现CsvltemProcessor。
        CsvItemProcessor processor = new CsvItemProcessor();
        //②为processor 指定校验器为CsvBean Validator；
        processor.setValidator(csvBeanValidator());
        return processor;
    }


    @Bean

    /**
     *  ①Spring 能让容器中已有的Bean以参数的形式注入，Spring Boot已为我们定义了dataSource。
     * */
    public ItemWriter<Person> writer(DataSource dataSource) {
        //②我们使用JDBC批处理的JdbcBatchltemWriter来写数据到数据库。
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        String sql = "insert into person " + "(id,name,age,address) "
                + "values(hibernate_sequence.nextval, :name, :age, :address)";
        //③在此设置要执行批处理的SQL语句。
        writer.setSql(sql);
        writer.setDataSource(dataSource);
        return writer;
    }

    /**
     * jobRepository的定义需要dataSource和transactioManager，Spring Boot已为我们自动配置了这两个类，Spring可通过方法注入已有的Bean。
     */
    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("oracle");
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                //①为Job指定Step。
                .flow(s1)
                .end()
                //②绑定监听器csvJobListener。
                .listener(csvJobListener())
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader, ItemWriter<Person> writer,
                      ItemProcessor<Person, Person> processor) {
        return stepBuilderFactory
                .get("step1")
                //①批处理每次提交65000条数据。
                .<Person, Person>chunk(65000)
                //②给step绑定reader。
                .reader(reader)
                //③给step绑定processor。
                .processor(processor)
                //④给step绑定writer。
                .writer(writer)
                .build();
    }


    @Bean
    public CsvJobListener csvJobListener() {
        return new CsvJobListener();
    }

    @Bean
    public Validator<Person> csvBeanValidator() {
        return new CsvBeanValidator<Person>();
    }
}
