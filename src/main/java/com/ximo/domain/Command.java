package com.ximo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by 朱文赵
 * 2017/9/29
 */
@Data
@NoArgsConstructor
public class Command {

    /** id*/
    private Integer id;

    /** 指令名称*/
    private String name;

    /** 指令描述*/
    private String description;

    /** 存放 内容List*/
    private List<CommandContent> contentList;

    /**自定义指令*/
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
