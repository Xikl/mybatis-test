package com.ximo.test;

import java.util.List;

/**
 * Created by 朱文赵
 * 2017/10/2
 */
public class MyMain {

    public static void main(String[] args) {
        System.out.println("加载配置信息");
        System.out.println("通过加载配置信息来加载一个代理工厂Map");
        System.out.println("通过这个Map存放接口class和对应的代理工厂");
        SqlSession sqlSession = new SqlSession();
        MyInterface myInterface = sqlSession.getMapper(MyInterface.class);
        List<Object> list = myInterface.query(new Object());
        System.out.println(list.size());
    }

}
