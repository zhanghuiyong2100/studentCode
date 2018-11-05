package com.springmvc4.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 章辉勇
 * @创建时间 2018年11月01日
 * @描述: springmvc4x自定义拦截器示例
 **/
/**
 * ① 继承HandlerInterceptorAdapter类来实现自定义拦截器。
 * */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    /**
     *  ② 重写preHandle方法，在请求发生前执行。
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        String contextPath = request.getServletPath();
        if ("/index".equals(contextPath)){
            return true;
        }
        //response.sendRedirect("专属勋章");
        //System.out.println("专属勋章");
        return true;
    }

    /**
     * ③ 重写postHandle方法，在请求完成后执行。
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+new Long(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
