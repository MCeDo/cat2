package com.cedo.common.http;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页类
 * @Author chendong
 * @date 19-3-3 下午3:53
 */
public class Page {

    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页数量
     */
    private Integer size;
    //总页数
    private Integer totalPage;

    @JsonIgnore
    private Integer start;

    //总记录数
    private Long count;

    public Page() {
    }

    public Page(Integer currentPage, Integer size) {
        this.currentPage = currentPage;
        this.size = size;
    }

    public Page(Integer currentPage, Integer size, Long count) {
        this.currentPage = currentPage;
        this.size = size;
        this.count = count;
    }

    public Integer getStart() {
        return (currentPage - 1) * size;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        if(totalPage%size == 0) this.totalPage = (int)totalPage/size;
        else this.totalPage = (int)totalPage/size + 1;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 构造包含分页查询条件的map
     * @return
     */
    public Map<String, Object> createMap() {
        Map<String, Object> map = new HashMap<>();
        if(this.currentPage==null || this.size==null) {
            return new HashMap<>();
        }
        map.put("start", this.getStart());
        map.put("size", this.getSize());
        return map;
    }
}
