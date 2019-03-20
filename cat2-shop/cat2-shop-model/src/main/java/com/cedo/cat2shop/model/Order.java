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

/**
 * 订单
 *
 * @author chendong
 * @date 2019-03-02 20:40:25
 */
@TableName("orders")
@ApiModel(description = "订单")
@Data
public class Order implements Serializable {
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
    private Integer productId;
	/**
	 * 物品名称
	 */
    @ApiModelProperty(value = "物品名称", example = "测试物品名称001")
    @Length(message="物品名称不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="物品名称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String productName;
	/**
	 * 物品数量
	 */
    @ApiModelProperty(value = "物品数量", example = "true")
    private Integer count;
	/**
	 * 物品单价
	 */
    @ApiModelProperty(value = "物品单价", example = "1")
    @NotNull(message="物品单价不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer price;
	/**
	 * 总价
	 */
    @ApiModelProperty(value = "总价", example = "1")
    private Integer totalPrice;
	/**
	 * 买家用户ID
	 */
    @ApiModelProperty(value = "买家用户ID", example = "1")
    @NotNull(message="买家用户ID不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Integer userId;
	/**
	 * 收货人
	 */
    @ApiModelProperty(value = "收货人", example = "测试收货人001")
    @Length(message="收货人不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="收货人不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String consignee;
	/**
	 * 联系电话
	 */
    @ApiModelProperty(value = "联系电话", example = "测试联系电话001")
    @Length(message="联系电话不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="联系电话不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String phone;
	/**
	 * 是否支付（0未支付，1已支付）
	 */
    @ApiModelProperty(value = "是否支付（0未支付，1已支付）", example = "测试是否支付（0未支付，1已支付）001")
    @Length(message="是否支付（0未支付，1已支付）不能超过1个字符", max = 1, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="是否支付（0未支付，1已支付）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String pay;
	/**
	 * 配送方式（自取，快递配送）
	 */
    @ApiModelProperty(value = "配送方式（自取，快递配送）", example = "测试配送方式（自取，快递配送）001")
    @Length(message="配送方式（自取，快递配送）不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="配送方式（自取，快递配送）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String delivery;
	/**
	 * 配送地址
	 */
    @ApiModelProperty(value = "配送地址", example = "测试配送地址001")
    @Length(message="配送地址不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="配送地址不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String address;
	/**
	 * 确认收货（0未收货，1已收货）
	 */
    @ApiModelProperty(value = "确认收货（0未收货，1已收货）", example = "测试确认收货（0未收货，1已收货）001")
    @Length(message="确认收货（0未收货，1已收货）不能超过1个字符", max = 1, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="确认收货（0未收货，1已收货）不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String confirm;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    @NotNull(message="创建时间不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private Date createdTime;
	/**
	 * 支付时间
	 */
    @ApiModelProperty(value = "支付时间", example = "2018-08-08")
    private Date paidTime;
	/**
	 * 配送时间（上门自提则为订单创建时间）
	 */
    @ApiModelProperty(value = "配送时间（上门自提则为订单创建时间）", example = "2018-08-08")
    private Date deliveryTime;
	/**
	 * 确认收获时间
	 */
    @ApiModelProperty(value = "确认收获时间", example = "2018-08-08")
    private Date confirmTime;
	/**
	 * 快递编号
	 */
    @ApiModelProperty(value = "快递编号", example = "测试快递编号001")
    @Length(message="快递编号不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="快递编号不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String postalCode;
}
