package com.springmvc4.converter;

import com.springmvc4.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author 章辉勇
 * @创建时间 2018年11月05日
 * @描述: 自定意HttpMessageConverter
 **/

/**
 * ① 继承AbstractHttpMessageConverter接口来实现自定义的HttpMessageConverter。
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    /**
     * ② 新建一个我们自定义的媒体类型application/x-longjiazuo。
     */
    public MyMessageConverter() {
        super(new MediaType("application", "x-longjiazuo", Charset.forName("UTF-8")));
    }

    /**
     * ③ 重写readInternal方法，处理请求的数据。代码表明我们处理由”-“隔开的数据，并转成DemoObj的对象。
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz,
                                   HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        String temp = StreamUtils.copyToString(inputMessage.getBody(),

                Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]), tempArr[1]);
    }

    /**
     * ④ 表明本HttpMessageConverter只处理DemoObj这个类。
     */
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    /**
     * ⑤ 重写writeInternal方法，处理如何输出数据到response。此例中，我们在原样输出前面加上"hello:"。
     */

    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello" + obj.getId() + "_" + obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
