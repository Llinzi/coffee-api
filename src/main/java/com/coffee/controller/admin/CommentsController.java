package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.entity.CommentsEntity;
import com.coffee.entity.ReplyEntity;
import com.coffee.service.CommentsService;
import com.coffee.service.ReplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : CommentsController
 * @Description : 评论控制器
 * @Author : 王显成
 * @Date: 2020-04-19 11:37
 */
@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private ReplyService replyService;

    /**
     * 查询评论
     * @param commentsEntity 评论实体
     * @return
     */
    @GetMapping(value = "/selectComments")
    public Result selectComments(CommentsEntity commentsEntity){
        try{
            PageInfo<CommentsEntity> pageInfo = commentsService.selectComments(commentsEntity);
            List<CommentsEntity> list = pageInfo.getList();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                map.put("total",pageInfo.getTotal());
                map.put("pages",pageInfo.getPages());
                map.put("pageNum",pageInfo.getPageNum());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的信息");
    }

    /**
     * 删除评论
     * @param commentsId 评论编号
     * @return
     */
    @PostMapping(value = "/deleteComments")
    public Result deleteComments(@RequestParam Integer commentsId){
        try{
            int i = commentsService.deleteComments(commentsId);
            //删除该评论的所有回复评论
            replyService.deleteBatchReply(commentsId);
            if (i > 0){
                return Result.ok("删除评论成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除评论失败！");
    }

    /**
     * 添加评论
     * @param commentsEntity 评论实体
     * @return
     */
    @PostMapping(value = "/addComments")
    public Result addComments(@RequestBody CommentsEntity commentsEntity){
        try {
            int i = commentsService.addComments(commentsEntity);
            if (i > 0){
                return Result.ok("评论成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("评论失败！");
    }

    /**
     * 查询回复评论
     * @param replyEntity 回复评论实体
     * @return
     */
    @GetMapping(value = "/selectReply")
    public Result selectReply(ReplyEntity replyEntity){
        try{
            PageInfo<ReplyEntity> pageInfo = replyService.selectReply(replyEntity);
            List<ReplyEntity> list = pageInfo.getList();
            if (list.size() > 0 && list != null){
                Map<String,Object> map = new HashMap<>();
                map.put("dataList",list);
                map.put("total",pageInfo.getTotal());
                map.put("pages",pageInfo.getPages());
                map.put("pageNum",pageInfo.getPageNum());
                return Result.ok(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("没有查询到满足条件的信息");
    }

    /**
     * 删除回复评论
     * @param replyId 回复评论id
     * @return
     */
    @PostMapping(value = "/deleteReply")
    public Result deleteReply(@RequestParam Integer replyId){
        try{
            int i = replyService.deleteReply(replyId);
            if (i > 0){
                return Result.ok("删除评论成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("删除评论失败！");
    }

    /**
     * 添加回复评论
     * @param replyEntity
     * @return
     */
    @PostMapping(value = "/addReply")
    public Result addReply(@RequestBody ReplyEntity replyEntity){
        try {
            int i = replyService.addReply(replyEntity);
            if (i > 0){
                return Result.ok("评论成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("评论失败！");
    }


}
