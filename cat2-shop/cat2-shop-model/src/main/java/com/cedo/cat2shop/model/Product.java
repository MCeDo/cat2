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

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 闲置物品
 *
 * @author chendong
 * @date 2019-03-02 20:39:40
 */
@TableName("product")
@ApiModel(description = "闲置物品")
@Data
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 物品名称
	 */
    @ApiModelProperty(value = "物品名称", example = "测试物品名称001")
    @Length(message="物品名称不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="物品名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String name;
	/**
	 * 类别ID
	 */
    @ApiModelProperty(value = "类别ID", example = "1")
    @NotNull(message="类别ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer cateId;
	/**
	 * 类别名称
	 */
    @ApiModelProperty(value = "类别名称", example = "测试类别名称001")
    @Length(message="类别名称不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="类别名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String cate;
	/**
	 * 发布者ID
	 */
    @ApiModelProperty(value = "发布者ID", example = "1")
    @NotNull(message="发布者ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer userId;
	/**
	 * 发布者名称
	 */
    @ApiModelProperty(value = "发布者名称", example = "测试发布者名称001")
    @Length(message="发布者名称不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="发布者名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String username;
	/**
	 * 所属学校
	 */
    @ApiModelProperty(value = "所属学校", example = "测试所属学校001")
    @Length(message="所属学校不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="所属学校不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String school;
	/**
	 * 物品描述
	 */
    @ApiModelProperty(value = "物品描述", example = "测试物品描述001")
    @Length(message="物品描述不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="物品描述不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String description;
	/**
	 * 物品标题
	 */
    @ApiModelProperty(value = "物品标题", example = "测试物品标题001")
    @Length(message="物品标题不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="物品标题不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String title;
	/**
	 * 几成新
	 */
    @ApiModelProperty(value = "几成新", example = "true")
    @NotNull(message="几成新不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer newLevel;
	/**
	 * 是否议价（0否 1是）
	 */
    @ApiModelProperty(value = "是否议价（0否 1是）", example = "测试是否议价（0否 1是）001")
    @Length(message="是否议价（0否 1是）不能超过1个字符", max = 1, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="是否议价（0否 1是）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String bahrain;
	/**
	 * 类型为 int 用价格*100 这样可以避免精度的缺失
	 */
    @ApiModelProperty(value = "类型为 int 用价格*100 这样可以避免精度的缺失", example = "1")
    @NotNull(message="类型为 int 用价格*100 这样可以避免精度的缺失不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer price;
	/**
	 * 物品的详细地址
	 */
    @ApiModelProperty(value = "物品的详细地址", example = "测试物品的详细地址001")
    @Length(message="物品的详细地址不能超过64个字符", max = 64, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="物品的详细地址不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String address;
	/**
	 * 发布时间
	 */
    @ApiModelProperty(value = "发布时间", example = "2018-08-08")
    @NotNull(message="发布时间不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Date createdTime;
	/**
	 * 最后修改时间
	 */
    @ApiModelProperty(value = "最后修改时间", example = "2018-08-08")
    private Date updateTime;

    /**
     * 物品图片
     */
    private transient List<ProductPic> images;
}
