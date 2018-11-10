package com.springboot.api.main;


import com.springboot.api.aspect.Action;

/**
 * @author 章辉勇
 * @创建时间 2018年11月08日
 * @描述: 遞歸階層測試
 **/

public class TestMain {
    public static void main(String[] args) {
        int i = jiechen(8);
        System.out.println(i);
        int j=2;
        if (j<10){
            j=1+j;
        }else if (j<100){
            j=10+j;
        }
        System.out.println(j);


    }


    public static int jiechen(int num) {
        System.out.println("開始進來" + num);
        if (num == 1) {
            return 1;
        }
        return num * jiechen(num - 1);
    }
}
