package com.ximo.interceptor;

import com.ximo.entity.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * 分页拦截器
 * Created by 朱文赵
 * 2017/10/5
 * 拦截prepare方法
 */
@Intercepts({@Signature(type= StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor{


    @Override
//    @SuppressWarnings("unchecked")
    public Object intercept(Invocation invocation) throws Throwable {
        //获得该对象
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获得相关的属性 具体可以查看源码
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement
                = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //获得配置文件中sqlId
        String sqlId = mappedStatement.getId();
        if(sqlId.matches(".+ByPage$")){
            BoundSql boundSql = statementHandler.getBoundSql();
            //原始Sql语句
            String sql = boundSql.getSql();
            //查询总条数的sql语句
            String countSql = "select count(*) from ("+ sql +")a";
            //获得连接
            Connection connection = (Connection) invocation.getArgs()[0];
            //预编译countSql
            PreparedStatement preparedStatement = connection.prepareStatement(countSql);
            //获得参数 为sql赋值
            ParameterHandler parameterHandler
                    = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            //加入分页条件
            Map<?, ?> param = (Map<?, ?>) boundSql.getParameterObject();
            Page page = (Page) param.get("page");
            if(rs.next()){
                //将获得 count
                page.setTotalNumber(rs.getInt(1));
            }
            //重写sql语句
            String pageSql = sql + " limit " + page.getDbIndex()+ "," + page.getDbNumber();
            //替换sql语句
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }
        //通过反射 调用
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
