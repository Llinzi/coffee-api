package com.coffee.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(discriminator = "返回数据对象")
@Data
public class AdminEntity {
    /**
     *
     */
    @ApiModelProperty(value = "管理员编号")
    private Integer id;

    /**
     * 管理员名称
     */
    @ApiModelProperty(value = "管理员名称")
    private String name;

    /**
     * 管理员密码
     */
    @ApiModelProperty(value = "管理员密码")
    private String pwd;

}

