package com.wmp.common.base.dto;

/**
 * @ClassName: QueryBase
 * @Description: TODO(查询基础类)
 * @author chenaonan
 * @date 2018年8月8日 上午11:40:45
 */
public class QueryBase {

    //要排序的字段名
    protected String sort;
    
    //排序方式: desc \ asc
    protected Integer order;
    
    //获取一页行数 
    protected int limit;
    
    //获取的页码 
    protected int page;
    
    // 起始记录 
    protected int offset;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return (this.page-1)*limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
