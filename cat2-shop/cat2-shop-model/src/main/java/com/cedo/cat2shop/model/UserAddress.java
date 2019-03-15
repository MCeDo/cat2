package com.cedo.cat2shop.model;

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

import java.io.Serializable;

/**
 * 用户地址
 *
 * @author chendong
 * @date 2019-03-02 20:40:53
 */
@TableName("user_address")
@ApiModel(description = "用户地址")
@Data
public class UserAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 用户ID
	 */
    @ApiModelProperty(value = "用户ID", example = "1")
    @NotNull(message="用户ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer userId;
	/**
	 * 详细地址
	 */
    @ApiModelProperty(value = "详细地址", example = "测试详细地址001")
    @Length(message="详细地址不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="详细地址不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String address;
	/**
	 * 是否默认地址（0不是，1是）
	 */
    @ApiModelProperty(value = "是否默认地址（0不是，1是）", example = "测试是否默认地址（0不是，1是）001")
    @Length(message="是否默认地址（0不是，1是）不能超过1个字符", max = 1, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="是否默认地址（0不是，1是）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String defaultAddress;
}
