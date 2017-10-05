package com.ximo.service;

import com.ximo.dao.MessageDao;
import com.ximo.domain.Message;
import com.ximo.entity.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 朱文赵
 * 2017/10/5
 */
public class QueryService {

    public List<Message> getMessageList(String command, String description, Page page){
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        MessageDao messageDao = new MessageDao();
        //根据条件查询参数
        int totalNumber = messageDao.count(message);
        page.setTotalNumber(totalNumber);
        Map<String, Object> param = new HashMap<>();
        param.put("message", message);
        param.put("page", page);
        return messageDao.getMessageList(param);


    }


}
