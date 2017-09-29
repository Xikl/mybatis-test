package com.ximo.dao;

import com.ximo.domain.Message;
import com.ximo.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱文赵
 * 2017/9/29
 */
public class MessageDao {

    /**
     * 查询列表
     * @return messageList
     */
    public List<Message> getMessageByCommandAndDescription(String command, String description){
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<>();
        try {
            //获得session
            sqlSession = DBUtil.getSqlSession();
            Message message = new Message(command, description);
            //执行sql语句 获得相应的id属性
            messageList = sqlSession.selectList("Message.getMessageList", message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
        return messageList;
    }


}