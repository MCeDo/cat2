package com.cedo.cat2auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2auth.model.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * 
 * @author chendong
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:33:28
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	
}
