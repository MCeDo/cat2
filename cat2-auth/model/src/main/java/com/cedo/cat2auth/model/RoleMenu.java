package com.cedo.cat2auth.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 角色-菜单
 *
 * @author chendong
 * @date 2019-03-02 20:45:19
 */
@TableName("role_menu")
@ApiModel(description = "角色-菜单")
@Data
public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
    @ApiModelProperty(value = "角色ID", example = "1")
    private Integer roleId;
	/**
	 * 菜单ID
	 */
    @ApiModelProperty(value = "菜单ID", example = "1")
    private Integer menuId;
}
