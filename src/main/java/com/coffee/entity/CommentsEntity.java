package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : Comments
* @Description : 评论实体类
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
@Data
@Table(name = "comments")
public class CommentsEntity implements Serializable {
    /**
     * 评论编号
     */
    @Id
    @Column(name = "comments_id")
    @GeneratedValue(generator = "JDBC")
    private Integer commentsId;

    /**
     * 咖啡编号
     */
    @Column(name = "coffee_id")
    private Integer coffeeId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 评论内容
     */
    @Column(name = "comments_content")
    private String commentsContent;

    @Column(name = "comments_filter_content")
    private String commentsFilterContent;

    /**
     * 评论时间
     */
    @Column(name = "comments_date")
    private Date commentsDate;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 头像
     */
    private String userHphoto;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    private static final long serialVersionUID = 1L;
}