package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.common.SensitiveWordUtil;
import com.coffee.entity.CommentsEntity;
import com.coffee.entity.ReplyEntity;
import com.coffee.service.CommentsService;
import com.coffee.service.ReplyService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import java.util.Set;

/**
 * @ClassName : CommentsController
 * @Description : 评论控制器
 * @Author : 王显成
 * @Date: 2020-04-19 11:37
 */
@Api(value = "CommentsController",tags = "评论控制器")
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
    @ApiOperation(value = "查询评论",httpMethod = "GET")
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
    @ApiOperation(value = "删除评论",httpMethod = "POST")
    @ApiImplicitParam(name = "coffeeId",value = "评论编号",required = true,dataType = "Integer")
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
    @ApiOperation(value = "添加评论",httpMethod = "POST")
    @PostMapping(value = "/addComments")
    public Result addComments(@RequestBody CommentsEntity commentsEntity){
        //初始化敏感词库
        SensitiveWordUtil.init();
        System.out.println("敏感词的数量：" + SensitiveWordUtil.sensitiveWordMap.size());
        System.out.println("待检测语句字数：" + commentsEntity.getCommentsContent().length());

        //是否含有关键字
        boolean result = SensitiveWordUtil.contains(commentsEntity.getCommentsContent(), SensitiveWordUtil.MinMatchType);
        System.out.println(result);

        //获取语句中的敏感词
        Set<String> set = SensitiveWordUtil.getSensitiveWord(commentsEntity.getCommentsContent(), SensitiveWordUtil.MinMatchType);
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);

        //替换语句中的敏感词
        String filterStr = SensitiveWordUtil.replaceSensitiveWord(commentsEntity.getCommentsContent(), '*', SensitiveWordUtil.MinMatchType);
        System.out.println(filterStr);

        String filterStr2 = SensitiveWordUtil.replaceSensitiveWord(commentsEntity.getCommentsContent(), "[*敏感词*]", SensitiveWordUtil.MinMatchType);
        System.out.println(filterStr2);
        commentsEntity.setCommentsFilterContent(filterStr);
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
    @ApiOperation(value = "添加评论",httpMethod = "GET")
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
    @ApiOperation(value = "删除回复评论",httpMethod = "POST")
    @ApiImplicitParam(name = "replyId",value = "回复评论id",required = true,dataType = "Integer")
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
    @ApiOperation(value = "添加回复评论",httpMethod = "POST")
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
