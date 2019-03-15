package com.cedo.cat2auth.client.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2auth.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author chendong
 * @date 19-3-1 下午2:37
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
