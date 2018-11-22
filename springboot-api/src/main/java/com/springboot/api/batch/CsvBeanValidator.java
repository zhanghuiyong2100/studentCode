package com.springboot.api.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author 章辉勇
 * @创建时间 2018年11月20日
 * @描述: Batch数据校验
 **/

public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {
    private javax.validation.Validator validator;


    /**
     * ①使用JSR-303的Validator来校验我们的数据，在此处进行JSR-303的Validator的初始化。
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Override
    public void validate(T t) throws ValidationException {
        /**
         * ②使用Validator的validate方法校验数据。
         * */
        Set<ConstraintViolation<T>> validate = validator.validate(t);
        if (validate.size() > 0) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> tConstraintViolation : validate) {
                message.append(tConstraintViolation.getMessage() + "\n");
            }
            throw new ValidationException(message.toString());
        }

    }
}
