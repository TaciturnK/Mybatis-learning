package com.taowd.entry;

public class BookType {

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 类型名
	 */
	private String typeName;

	@Override
	public String toString() {
		return "BookType [id=" + id + ", typeName=" + typeName + "]";
	}

	public BookType() {
		super();
	}

	public BookType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
