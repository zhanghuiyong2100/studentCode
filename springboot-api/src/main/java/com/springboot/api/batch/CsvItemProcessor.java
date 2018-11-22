package com.springboot.api.batch;

import com.springboot.api.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * @author 章辉勇
 * @创建时间 2018年11月20日
 * @描述: Bacth数据处理
 **/

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override

    public Person process(Person item) throws ValidationException {
        /**
         * ①需执行super.proces:（item）才会调用自定义校验器。
         * */
        super.process(item);
        /**
         * 判断是否成年
         * */
        if (18 > item.getAge()) {
            item.setAge(01);
        } else {
            item.setAge(02);
        }
        return item;
    }
}
