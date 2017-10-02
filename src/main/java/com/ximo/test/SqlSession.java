package com.ximo.test;


import java.lang.reflect.Proxy;

/**
 * Created by 朱文赵
 * 2017/10/2
 */
public class SqlSession {

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type){
        System.out.println("通过接口的代理工厂取出相对应的代理工厂");
        System.out.println("通过代理工厂实例化一个代理类");
        System.out.println("通过这个代理类生成一个代理实例返回");
        return (T)Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy());
    }



}
