package com.cedo.cat2auth.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cedo.common.validator.AddGroup;
import com.cedo.common.validator.UpdateGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author chendong
 * @date 19-2-28 下午4:55
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "帐号（手机号码）", example = "1356000000")
    @Length(message="手机号码格式错误", max = 12, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="手机号码不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String username;

    @ApiModelProperty(value = "密码", example = "123456")
    @NotBlank(message="密码不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String password;

    @ApiModelProperty(value = "用户昵称", example = "昵称001")
    @Length(message="用户昵称不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    @NotBlank(message="用户昵称不能为空", groups = {AddGroup.class ,  UpdateGroup.class})
    private String nickname;

    private String salt;
    private Integer roleId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", example = "测试真实姓名001")
    @Length(message="真实姓名不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    private String actualName;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", example = "测试头像001")
    @Length(message="头像不能超过255个字符", max = 255, groups = {AddGroup.class ,  UpdateGroup.class})
    private String avator;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", example = "测试邮箱001")
    @Length(message="邮箱不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    private String email;
    /**
     * 所属学校
     */
    @ApiModelProperty(value = "所属学校", example = "测试所属学校001")
    @Length(message="所属学校不能超过16个字符", max = 16, groups = {AddGroup.class ,  UpdateGroup.class})
    private String school;
    /**
     * 支付宝帐号
     */
    @ApiModelProperty(value = "支付宝帐号", example = "测试支付宝帐号001")
    @Length(message="支付宝帐号不能超过32个字符", max = 32, groups = {AddGroup.class ,  UpdateGroup.class})
    private String alipay;
}
