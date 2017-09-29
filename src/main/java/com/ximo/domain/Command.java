package com.ximo.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by 朱文赵
 * 2017/9/29
 */
@Data
public class Command {

    private Integer id;
    private String name;
    private String description;
    private List<CommandContent> commandContentList;

}
