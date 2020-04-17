package com.coffee.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coffee.mapper.CommentsMapper;
import com.coffee.service.CommentsService;
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

}
