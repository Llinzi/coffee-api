package com.coffee.entity;

import java.io.Serializable;
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
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 评论内容
     */
    @Column(name = "comments_content")
    private String commentsContent;

    /**
     * 评论等级
     */
    @Column(name = "comments_level")
    private String commentsLevel;

    private static final long serialVersionUID = 1L;
}