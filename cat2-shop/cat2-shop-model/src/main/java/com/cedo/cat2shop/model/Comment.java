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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import java.util.Date;
import java.io.Serializable;

/**
 * 留言类
 *
 * @author chendong
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:41:59
 */
@TableName("comment")
@ApiModel(description = "留言类")
@Data
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 发布留言者ID
	 */
    @ApiModelProperty(value = "发布留言者ID", example = "1")
    @NotNull(message="发布留言者ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer userId;
	/**
	 * 发布留言者名称
	 */
    @ApiModelProperty(value = "发布留言者名称", example = "测试发布留言者名称001")
    @Length(message="发布留言者名称不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="发布留言者名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String username;
	/**
	 * 留言内容
	 */
    @ApiModelProperty(value = "留言内容", example = "测试留言内容001")
    @Length(message="留言内容不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="留言内容不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String content;
	/**
	 * 物品ID
	 */
    @ApiModelProperty(value = "物品ID", example = "1")
    @NotNull(message="物品ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer productId;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    @NotNull(message="创建时间不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Date createdTime;
	/**
	 * 回复人的ID,不是回复他人的评论则为0
	 */
    @ApiModelProperty(value = "回复人的ID,不是回复他人的评论则为0", example = "1")
    private Integer replyId;
	/**
	 * 回复人的名称
	 */
    @ApiModelProperty(value = "回复人的名称", example = "测试回复人的名称001")
    @Length(message="回复人的名称不能超过32个字符", max = 32)
    private String replyName;
}
