package com.cedo.cat2shop.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-19 下午11:48
 */
public class PageUtil {

    public static IPage getPage(Map<String, Object> params) {
        Integer current = Integer.valueOf((String)params.get("page"));
        Integer limit = Integer.valueOf((String)params.get("limit"));
        return new Page(current, limit);
    }
}
