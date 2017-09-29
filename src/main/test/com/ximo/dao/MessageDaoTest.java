package com.ximo.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 测试MessageDao的方法
 * Created by 朱文赵
 * 2017/9/29
 */
public class MessageDaoTest {

    private MessageDao messageDao;

    @Before
    public void init(){
        messageDao = new MessageDao();
    }


    @Test
    public void getMessageByCommandAndDescription() throws Exception {
        messageDao.getMessageByCommandAndDescription("", "段子");
    }

    @Test
    public void deleteOne() throws Exception {
        messageDao.deleteOne(3);
    }

    @Test
    public void deleteBatch() throws Exception {
        messageDao.deleteBatch(Arrays.asList(5,7,8));
    }
}