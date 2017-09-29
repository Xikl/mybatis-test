package com.ximo.dao;

import org.junit.Before;
import org.junit.Test;

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
        messageDao.getMessageByCommandAndDescription();
    }

}