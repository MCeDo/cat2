package com.cedo.cat2auth.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cedo.common.validator.AddGroup;
import com.cedo.common.validator.UpdateGroup;
import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.io.Serializable;

/**
 * 菜单类
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:37:43
 */
@TableName("menu")
@ApiModel(description = "菜单类")
@Data
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 菜单名称
	 */
    @ApiModelProperty(value = "菜单名称", example = "测试菜单名称001")
    @Length(message="菜单名称不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="菜单名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String name;
	/**
	 * 权限
	 */
    @ApiModelProperty(value = "权限", example = "测试权限001")
    @Length(message="权限不能超过64个字符", max = 64, groups = {AddGroup.class ,  UpdateGroup.class})
    private String permission;
	/**
	 * 父级菜单ID
	 */
    @ApiModelProperty(value = "父级菜单ID", example = "1")
    private Integer parentId;
	/**
	 * 前端url
	 */
    @ApiModelProperty(value = "前端url", example = "测试前端url001")
    @Length(message="前端url不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    private String path;
	/**
	 * VUE页面
	 */
    @ApiModelProperty(value = "VUE页面", example = "测试VUE页面001")
    @Length(message="VUE页面不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    private String compent;
	/**
	 * 排序值
	 */
    @ApiModelProperty(value = "排序值", example = "1")
    private Integer sort;
	/**
	 * 类型（0菜单 1按钮）
	 */
    @ApiModelProperty(value = "类型（0菜单 1按钮）", example = "1")
    @NotNull(message="类型（0菜单 1按钮）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer type;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    private Date createTime;
	/**
	 * 更新时间
	 */
    @ApiModelProperty(value = "更新时间", example = "2018-08-08")
    private Date updateTime;
	/**
	 * 逻辑删除标记（1--正常，0--删除）
	 */
    @ApiModelProperty(value = "逻辑删除标记（1--正常，0--删除）", example = "测试逻辑删除标记（1--正常，0--删除）001")
    @Length(message="逻辑删除标记（1--正常，0--删除）不能超过1个字符", max = 1, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="逻辑删除标记（1--正常，0--删除）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String delFlag;
}
