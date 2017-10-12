package com.taowd.mybatis.entry;

public class Orders {

	private String id;
	private String no;
	private String price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", no=" + no + ", price=" + price + "]";
	}

}
