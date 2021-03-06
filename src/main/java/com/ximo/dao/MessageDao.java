package com.ximo.dao;

import com.ximo.domain.Message;
import com.ximo.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 朱文赵
 * 2017/9/29
 */
public class MessageDao {

    /**
     * 查询列表
     * @return messageList
     */
    public List<Message> getMessageList(Map<String, Object> param){
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<>();
        try {
            //获得session
            sqlSession = DBUtil.getSqlSession();
            //执行sql语句 获得相应的id属性
//            messageList = sqlSession.selectList("Message.getMessageList", message);
            //面向接口编程
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            messageList = iMessage.getMessageList(param);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
        return messageList;
    }

    /**
     * 删除该信息
     * @param id
     */
    public void deleteOne(Integer id){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            sqlSession.delete("Message.deleteOne", id);
            //采用事务提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }

    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(List<Integer> ids){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            sqlSession.delete("Message.deleteBatch", ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
    }

    /**
     * 分页方法
     * @param message
     * @return
     */
    public Integer count(Message message){
        SqlSession sqlSession = null;
        int result = 0;
        try {
            sqlSession = DBUtil.getSqlSession();
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            result = iMessage.count(message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
        return result;
    }

    /**
     * 拦截器 方法
     * @param param
     * @return
     */
    public List<Message> queryMessageListByPage(Map<String, Object> param){
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<>();
        try {
            sqlSession = DBUtil.getSqlSession();
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            messageList = iMessage.queryMessageListByPage(param);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
        return messageList;

    }



}