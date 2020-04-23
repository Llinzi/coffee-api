package com.coffee.mapper;

import com.coffee.entity.ReplyEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : ReplyMapper
* @Description : $评论回复
* @Author : 王显成 
* @Date: 2020-04-18 19:18
*/
public interface ReplyMapper extends Mapper<ReplyEntity> {

    /**
     * 查询回复评论
     * @param replyEntity
     * @return
     */
    List<ReplyEntity> selectReply(ReplyEntity replyEntity);

    /**
     * 批量删除评论
     * @param commentsId
     * @return
     */
    int deleteBatchReply(Integer commentsId);

}