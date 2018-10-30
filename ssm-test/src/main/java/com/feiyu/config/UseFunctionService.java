package com.feiyu.config;

/**
 * @author 章辉勇
 * @创建时间 2018年10月25日
 * @描述: 实现java配置
 **/


public class UseFunctionService {


    FunctionService functionService;


    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String SayHello(String word) {
        return functionService.sayHallo(word);
    }


}
