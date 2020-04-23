package com.coffee.service.impl;

import com.coffee.entity.ReplyEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.ReplyMapper;
import com.coffee.service.ReplyService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @ClassName : ReplyServiceImpl
* @Description : ${description}
* @Author : 王显成 
* @Date: 2020-04-18 19:18
*/
@Service
public class ReplyServiceImpl implements ReplyService{

    @Resource
    private ReplyMapper replyMapper;

    @Override
    public PageInfo<ReplyEntity> selectReply(ReplyEntity replyEntity) {
        PageHelper.startPage(replyEntity.getCurrentPage(),replyEntity.getPageSize());
        List<ReplyEntity> list = replyMapper.selectReply(replyEntity);
        return new PageInfo<>(list);
    }

    @Override
    public int deleteReply(Integer replyId) {
        return replyMapper.deleteByPrimaryKey(replyId);
    }

    @Override
    @Transactional
    public int deleteBatchReply(Integer commentsId) {
        return replyMapper.deleteBatchReply(commentsId);
    }

    @Override
    public int addReply(ReplyEntity replyEntity) {
        return replyMapper.insertSelective(replyEntity);
    }
}
