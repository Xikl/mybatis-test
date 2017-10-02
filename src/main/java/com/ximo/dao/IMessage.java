package com.ximo.dao;

import com.ximo.domain.Message;

import java.util.List;

/**
 * 与Message中配置相对应的接口
 * Created by 朱文赵
 * 2017/9/29
 */
public interface IMessage {

    List<Message> getMessageList(Message message);


}
