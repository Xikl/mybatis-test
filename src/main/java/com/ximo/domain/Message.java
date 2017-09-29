package com.ximo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 朱文赵
 * 2017/9/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    /** id */
    private Long id;

    /** 类别 */
    private String command;

    /** 描述 */
    private String description;

    /** 内容 */
    private String content;

    /**自定义构造函数*/
    public Message(String command, String description) {
        this.command = command;
        this.description = description;
    }
}
