package com.ximo.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 朱文赵
 * 2017/9/29
 */
public class CommandDaoTest {

    private CommandDao commandDao;

    @Before
    public void init(){
        commandDao = new CommandDao();
    }

    @Test
    public void getCommandList() throws Exception {
        commandDao.getCommandList("段子", "");
    }

}