package com.cedo.security.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author chendong
 * @date 19-2-28 下午5:25
 */
@Data
public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long userId;
    private String token;
    private Date expireTime;
    private Date lastUpdateTime;

    public UserToken() {
    }

    public UserToken(Long userId, String token, Date expireTime, Date lastUpdateTime) {
        this.userId = userId;
        this.token = token;
        this.expireTime = expireTime;
        this.lastUpdateTime = lastUpdateTime;
    }
}
