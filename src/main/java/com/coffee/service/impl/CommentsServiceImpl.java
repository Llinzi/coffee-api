package com.coffee.service.impl;

import com.coffee.entity.CommentsEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.CommentsMapper;
import com.coffee.service.CommentsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @ClassName : CommentsServiceImpl
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-12 15:04
*/
@Service
public class CommentsServiceImpl implements CommentsService{

    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public PageInfo<CommentsEntity> selectComments(CommentsEntity commentsEntity) {
        PageHelper.startPage(commentsEntity.getCurrentPage(),commentsEntity.getPageSize());
        List<CommentsEntity> list = commentsMapper.selectComments(commentsEntity);
        return new PageInfo<>(list);
    }

    @Override
    @Transactional
    public int deleteComments(Integer commentsId) {
        return commentsMapper.deleteByPrimaryKey(commentsId);
    }

    @Override
    public int addComments(CommentsEntity commentsEntity) {
        commentsEntity.setCommentsDate(new Date());
        return commentsMapper.insertSelective(commentsEntity);
    }
}
