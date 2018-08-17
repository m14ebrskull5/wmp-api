package com.wmp.common.base.dto;

import java.util.List;
/**
 * @ClassName: Page
 * @Description: TODO(分页实体类)
 * @author chenaonan
 * @date 2018年8月8日 上午11:26:28
 */
@SuppressWarnings("rawtypes")
public class Page {
	
	private List rows;
	private long total;
	
	public Page(){}
	
	public Page(List rows, long total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Page [rows=" + rows + ", total=" + total + "]";
	}
}
