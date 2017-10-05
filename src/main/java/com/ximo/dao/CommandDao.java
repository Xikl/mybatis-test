package com.ximo.dao;

import com.ximo.domain.Command;
import com.ximo.domain.CommandContent;
import com.ximo.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作command
 * Created by 朱文赵
 * 2017/9/29
 */
public class CommandDao {

    /**
     * 通过name和 description描述来查询
     * @param name
     * @param description
     * @return
     */
    public List<Command> getCommandList(String name, String description){
        List<Command> commandList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            //传入参数
            Command command = new Command(name, description);
            commandList = sqlSession.selectList("Command.getCommandList", command);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
        return commandList;
    }

    /**
     * 批量新增
     * @param contents
     */
    public void insertBatch(List<CommandContent> contents){
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
            iCommandContent.insertBatch(contents);
            //采用事务提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(sqlSession);
        }
    }

}
