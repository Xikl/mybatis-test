package com.ximo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * DB工具类
 * Created by 朱文赵
 * 2017/9/29
 */
public class DBUtil {

    private static final String CONFIG_PATH = "Configuration.xml";

    /** 获得sqlSession*/
    public static SqlSession getSqlSession() throws IOException {
        //通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader(CONFIG_PATH);
        //通过配置信息构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //打开SqlSession 并返回
        return sqlSessionFactory.openSession();
    }

    /** 关闭方法*/
    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

}
