package com.asisinfo.utils;

import java.io.Serializable;
import java.util.List;

public class MyPage<T,K> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录条数
     */
    private int totalRecord;

    /**
     * 记录列表
     */
    private List<K> records;
    /**
     * 偏移量
     */
    private int offset;
    /**
     * 页码
     */
    private int page;

    /**
     * 每页显示长度
     */
    private int pageSize;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 排序字段
     */
    private String sort;
    /**
     * 排序
     */
    private String order;

    /**
     * 条件实体类
     */
    private K queryModel;

    public K getQueryModel() {
        return queryModel;
    }

    public void setQueryModel(K queryModel) {
        this.queryModel = queryModel;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<K> getRecords() {
        return records;
    }

    public void setRecords(List<K> records) {
        this.records = records;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPage() {
        page=offset/pageSize;
        return page;
    }
}
