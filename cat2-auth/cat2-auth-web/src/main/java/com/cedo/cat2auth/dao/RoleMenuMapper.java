package com.cedo.cat2auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2auth.model.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色-菜单
 * 
 * @author chendong
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:45:19
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
	
}
