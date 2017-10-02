package com.ximo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱文赵
 * 2017/10/2
 */
public class MapperProxy implements InvocationHandler{


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("通过接口和method获得相应的配置文件信息");
        System.out.println("接口名称.方法名 == namespace.id");
        System.out.println("通过配置文件的信息获得sql语句的类型");
        System.out.println("通过该类型来调取相应的增删改查方法");
        System.out.println("如 当sql语句是查询的时候");
        System.out.println("更具返回值类型是list、Map和Object");
        System.out.println("来分别调用selectList、selectMap和SelectOne的方法");
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }
}
