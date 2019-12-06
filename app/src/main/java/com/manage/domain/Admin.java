package com.manage.domain;

/**
 * 功能：管理员实体类
 */
public class Admin {
	private String name;
	private String id;
	private String password;

	public Admin(String id,String name,String password){
		this.name=name;this.id=id;this.password=password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
