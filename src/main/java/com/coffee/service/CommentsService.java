package com.coffee.service;

import com.coffee.entity.CommentsEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : CommentsService
* @Description : 评论事务层
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
public interface CommentsService{

    /**
     * 查询评论
     * @param commentsEntity
     * @return
     */
    PageInfo<CommentsEntity> selectComments(CommentsEntity commentsEntity);

    /**
     * 删除评论
     * @param commentsId 评论编号
     * @return
     */
    int deleteComments(Integer commentsId);

    /**
     * 添加评论
     * @param commentsEntity 评论实体类
     * @return
     */
    int addComments(CommentsEntity commentsEntity);

}
