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
 * 物品图片
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:44:34
 */
@TableName("product_pic")
@ApiModel(description = "物品图片")
@Data
public class ProductPic implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 物品ID
	 */
    @ApiModelProperty(value = "物品ID", example = "1")
    @NotNull(message="物品ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Long productId;
	/**
	 * 图片URL
	 */
    @ApiModelProperty(value = "图片URL", example = "测试图片URL001")
    @Length(message="图片URL不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="图片URL不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String picUrl;
}
