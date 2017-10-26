package com.taowd.mybatis.entry;

public class Guser {

	private String id;
	private int age;
	private String name;

	public Guser() {
		super();
	}

	public Guser(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Guser [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

}
