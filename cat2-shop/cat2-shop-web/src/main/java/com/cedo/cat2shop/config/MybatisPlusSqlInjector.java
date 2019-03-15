package com.cedo.cat2shop.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.*;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * mybatis plus sql注入器
 * @Author chendong
 * @date 19-3-1 下午3:25
 */
public class MybatisPlusSqlInjector extends AbstractSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        return Stream.of(
                new Insert(),
                new InsertBatchSomeColumn(t -> true),
                new Delete(),
                new DeleteById(),
                new Update(),
                new UpdateById(),
                new UpdateAllColumnById(),
                new SelectById(),
                new SelectCount(),
                new SelectObjs(),
                new SelectList(),
                new SelectPage(),
                new SelectOne()
        ).collect(Collectors.toList());
    }
}
