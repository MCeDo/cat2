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

import java.io.Serializable;

/**
 * 角色
 *
 * @date 2019-03-02 20:33:28
 */
@TableName("role")
@ApiModel(description = "角色")
@Data
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 角色名称
	 */
    @ApiModelProperty(value = "角色名称", example = "测试角色名称001")
    @Length(message="角色名称不能超过64个字符", max = 64, groups = {AddGroup.class ,  UpdateGroup.class})
    private String name;
	/**
	 * 描述
	 */
    @ApiModelProperty(value = "描述", example = "测试描述001")
    @Length(message="描述不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    private String desc;
	/**
	 * 逻辑删除标记（1--正常，0--删除）
	 */
    @ApiModelProperty(value = "逻辑删除标记（1--正常，0--删除）", example = "测试逻辑删除标记（1--正常，0--删除）001")
    @Length(message="逻辑删除标记（1--正常，0--删除）不能超过1个字符", max = 1, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="逻辑删除标记（1--正常，0--删除）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String delFalg;
}
