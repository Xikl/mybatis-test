package com.ximo.dao;

import com.ximo.domain.CommandContent;

import java.util.List;

/**
 * Created by 朱文赵
 * 2017/10/5
 */
public interface ICommandContent {

    /**  单条新增*/
    void insertOne(CommandContent content);

    void insertBatch(List<CommandContent> contents);

}
