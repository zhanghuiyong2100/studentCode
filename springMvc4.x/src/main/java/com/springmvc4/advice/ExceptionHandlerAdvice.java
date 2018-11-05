package com.springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 章辉勇
 * @创建时间 2018年11月03日
 * @描述: 异常处理器
 **/

/**
 * ① @ControllerAdvice声明一个控制器建言，@ControllerAdvice组合了@Component注解，
 * 所以自动注册为Spring的Bean。
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     * ② @ExceptionHandler在此处定义全局处理，通过@ExceptionHandler的value属性可过滤拦截的条件，
     * 在此处可以看出拦截的是所有的Exception。
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        /**
         * ③ 此处使用@ModelAttribute注解将键值对添加到全局，所有注解了@RequestMapping的方法可获得此键值对。
         * */
        model.addAttribute("msg", "美妙的错误");
    }

    @InitBinder
    public void initbinder(WebDataBinder webDataBinder) {
        /**
         * ④ 通过@InitBinder注解定制WebDataBinder。
         * */
        webDataBinder.setDisallowedFields("id");
    }
}
