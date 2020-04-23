package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
* @ClassName : Reply
* @Description : $评论回复实体类
* @Author : 王显成 
* @Date: 2020-04-18 19:18
*/
@Data
@Table(name = "reply")
public class ReplyEntity implements Serializable {
    /**
     * 回复 id
     */
    @Id
    @Column(name = "reply_id")
    @GeneratedValue(generator = "JDBC")
    private Integer replyId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 回复评论的id
     */
    @Column(name = "comments_id")
    private Integer commentsId;

    /**
     * 回复评论的内容
     */
    @Column(name = "comments_content")
    private String commentsContent;

    /**
     * 回复评论的时间
     */
    @Column(name = "reply_date")
    private String replyDate;

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