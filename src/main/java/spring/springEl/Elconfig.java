package spring.springEl;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;


/**
 * @author 章辉勇
 * @创建时间 2018年10月26日
 * @描述: eljava配置
 **/

@Configuration
@ComponentScan("spring.springEl")
@PropertySource("classpath:spring/springEl/eltest.properties")
public class Elconfig {
    /**①注入普通字符串。*/
    @Value("T Love Y")
    private String normal;
    /**②注入操作系统属性。*/
    @Value("#{systemProperties['os.name']}")
    private String osName;
    /** ③注入表达式结果。 */
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;
    /** ④注入其他Bean属性。 */
    @Value("#{elDemoService.another}")
    private String fromAnother;
    /**  ⑤注入文件资源。*/
    @Value("classpath:spring/springEl/eltext.txt")
    private Resource testFile;
    /** ⑥注入网址资源。*/
    @Value("https://www.baidu.com/")
    private Resource testUrl;
    /**  ⑥注入配置文件 */
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;


    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    public void outputResource() {
        try {

            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
