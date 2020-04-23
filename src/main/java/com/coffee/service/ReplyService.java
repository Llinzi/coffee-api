package com.coffee.service;

import com.coffee.entity.ReplyEntity;
import com.github.pagehelper.PageInfo;

/**
* @ClassName : ReplyService
* @Description : 回复评论事务层
* @Author : 王显成 
* @Date: 2020-04-18 19:18
*/
public interface ReplyService{

        /**
         * 查询回复评论
         * @param replyEntity
         * @return
         */
        PageInfo<ReplyEntity> selectReply(ReplyEntity replyEntity);

        /**
         * 删除回复评论
         * @param replyId 回复评论编号
         * @return
         */
        int deleteReply(Integer replyId);

        /**
         * 批量删除评论
         * @param commentsId
         * @return
         */
        int deleteBatchReply(Integer commentsId);

        /**
         * 添加回复评论
         * @param replyEntity 回复评论实体类
         * @return
         */
        int addReply(ReplyEntity replyEntity);

}
