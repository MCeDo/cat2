package com.cedo.cat2auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2auth.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单类
 * 
 * @author chendong
 * @date 2019-03-02 20:37:43
 */
@Component
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findMenuByUserId(@Param("userId") long userId);

    List<Menu> findAll();
}
