package com.cedo.cat2shop.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.cedo.common.validator.AddGroup;
import com.cedo.common.validator.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 分类
 *
 * @author chendong
 * @date 2019-03-02 20:43:29
 */
@ApiModel(description = "分类")
@Data
public class Cate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 类别名称
	 */
    @ApiModelProperty(value = "类别名称", example = "测试类别名称001")
    @Length(message="类别名称不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="类别名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String name;
}
