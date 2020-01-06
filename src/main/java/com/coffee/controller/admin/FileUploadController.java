package com.coffee.controller.admin;

import com.coffee.common.Result;
import com.coffee.common.UploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : FileUploadController
 * @Description : 文件上传和删除控制器
 * @Author : 王显成
 * @Date: 2019-12-20 10:37
 */
@Api(value = "FileUploadController",tags = "文件上传和删除控制器接口")
@RestController
@RequestMapping(value = "/upload")
public class FileUploadController {

    private String userPath = "E:/workspace/images/users/";

    private String coffeePath = "E:/workspace/images/coffee/";


    /**
     * 上传图片
     * @param photo 上传的图片
     * @param type 上传的类型
     *             user为用户头像
     *             coffee为咖啡图片
     * @return 返回 Map集合信息
     * @throws IOException
     */
    @ApiOperation(value = "上传图片",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "photo", value = "图片", required = true, dataType = "file"),
            @ApiImplicitParam(name = "type", value = "类型" , required = true,dataType = "String")
    })
    @PostMapping(value="/uploadPhoto")
    public Result uploadPhoto(@RequestParam("photo") MultipartFile photo,
                              @RequestParam("type") String type) throws IOException {
        Map<String, Object> map = null;
        switch (type){
            case "user" :
                map = this.uploadFile(userPath, photo);
                if(map!=null && map.size() > 0) {
                    return Result.ok(map);
                }
            case "coffee" :
                map = this.uploadFile(coffeePath, photo);
                if(map!=null && map.size() > 0) {
                    return Result.ok(map);
                }
        }
        return Result.error("上传图片失败！");
    }

    /**
     * 删除图片
     * @param photo 删除的图片
     * @param type  删除类型
     *              user 删除用户头像
     *              coffee 删除咖啡图片
     * @return
     */
    @PostMapping(value = "/deletePhoto")
    public Result deletePhoto(@RequestParam("photo") String photo,
                              @RequestParam("type") String type){
        try {
            //从URL中获得商品图片的名字
            int indexOf = photo.lastIndexOf("/");
            if(indexOf!=-1) {
                String fileName = photo.substring(indexOf + 1);
                File file = null;
                switch (type){
                    case "user":
                        file = new File(this.userPath + fileName);
                        file.delete();
                        return Result.ok();
                    case "coffee":
                        file = new File(this.coffeePath + fileName);
                        file.delete();
                        return Result.ok();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("删除图片失败！");
    }


    /**
     * 上传文件
     *
     * @param path 上传文件的路径
     * @param file 上传的文件
     * @return 成功返回java.util.Map类型的实例，否则返回null
     * @throws IOException
     */
    private Result uploadFile(String path, MultipartFile file) throws IOException {
        // 获得新的文件名
        String fileName = UploadUtils.getFileName();
        // 根据上传文件的文件名获得文件的扩展名
        String extendedName = UploadUtils.getExtendedName(file.getOriginalFilename());

        //上传文件
        //1.将文件装换为字节类型的数组
        byte[] bytes = file.getBytes();
        //2.创建File类的对象，并设置文件名上传路径及文件名
        File saveFile = new File(path + fileName + extendedName);
        //3.上传文件
        FileCopyUtils.copy(bytes, saveFile);

        //当文件上传成功时，将文件新的文件名以扩展名传递回视图层
        Map<String,Object> map = new HashMap<>();
        map.put("fileName",fileName);
        map.put("extendedName", extendedName);
        return Result.ok(map);

    }

}
