package com.wmp.codeutils;

/**
 * @ClassName: ColumnModel
 * @Description: TODO(列模型)
 * @author chenaonan
 * @date 2018年8月8日 上午11:56:26
 */
public class ColumnModel {
	
	//是否是主键
	private boolean isPrimaryKey;
	//是否自增
	private boolean isAutoIncrement;
	//列名
	private String columnName;
	//数据类型
	private String dataType;
	//类型名称
	private String typeName;
	//列类名
	private String columnClassName;
	//字段名称
	private String fieldName;
	//字段类型
	private String fieldType;
	//字段大小
	private int columnSize;
	//默认值
	private String columnDef;
	//备注
	private String remarks;

	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}

	public void setAutoIncrement(boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getColumnDef() {
		return columnDef;
	}

	public void setColumnDef(String columnDef) {
		this.columnDef = columnDef;
	}

	public String getColumnClassName() {
		return columnClassName;
	}

	public void setColumnClassName(String columnClassName) {
		this.columnClassName = columnClassName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	@Override
	public String toString() {
		return "ColumnModel [columnName=" + columnName + ", dataType="
				+ dataType + ", typeName=" + typeName + ", columnClassName="
				+ columnClassName + ", fieldName=" + fieldName + ", fieldType="
				+ fieldType + ", columnSize=" + columnSize + ", columnDef="
				+ columnDef + ", remarks=" + remarks + "]";
	}

}

