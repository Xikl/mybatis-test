package com.ximo.entity;

import lombok.Data;

/**
 * 分页实体类
 * Created by 朱文赵
 * 2017/10/3
 */
@Data
public class Page {

    /** 总的条数*/
    private Integer totalNumber;

    /** 当前页*/
    private Integer currentPage;

    /** 总的页数*/
    private Integer totalPage;

    /** 每页显示多少条*/
    private Integer pageNumber = 5;

    /** 数据库部分 从第几条开始去查*/
    private Integer dbIndex;

    /** 数据库部分 一共取多少条*/
    private Integer dbNumber;


    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
        this.count();
    }

    /**
     *  更具当前属性计算相关值
     */
    public void count(){
        //总页数
        //        int totalPageTemp = this.totalNumber / this.pageNumber;
//        int plus = (this.totalNumber % this.pageNumber) == 0? 0: 1;
//        totalPageTemp = totalPageTemp + plus;
//        if (totalPageTemp <= 0){
//            totalPageTemp = 1;
//        }
        this.totalPage = (totalNumber + pageNumber - 1)/ pageNumber;
        //设置当前页数
        //总页数小于当前页数，应将当前页设置为总页数
        if(totalPage < this.currentPage){
            this.currentPage = this.totalPage;
        }
        //小于1的时候
        if(this.currentPage < 1){
            this.currentPage = 1;
        }
        this.dbIndex = (this.currentPage - 1) * this.pageNumber;
        this.dbNumber = this.pageNumber;
    }
}
