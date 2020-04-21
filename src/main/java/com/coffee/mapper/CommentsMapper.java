package com.coffee.mapper;

import com.coffee.entity.CommentsEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @ClassName : CommentsMapper
* @Description : $评论持久化层
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
public interface CommentsMapper extends Mapper<CommentsEntity> {
    /**
     * 查询评论
     * @param commentsEntity
     * @return
     */
    List<CommentsEntity> selectComments(CommentsEntity commentsEntity);
}