package com.manage.controller;

import com.manage.domain.User;
import com.manage.domain.UserList;

/**
 *员工controller
 */
public class Controller {
	/**
	 * 添加员工
	 */
	public boolean addUser(String userid, String username, String userdepartment) {
		UserList users=UserList.getUserList();

		User newuser=new User(userid,username,userdepartment);
		if(users.insert(newuser)){
			return true;
		}return false;

	}

	/**
	 * 删除员工
	 */
	public boolean deleteUser(String name){
		UserList users=UserList.getUserList();      
		if(users.delete(name))
			return true;
		return false;
	}

	/**
	 * 修改员工
	 */
	public boolean setUser(String userid, String username, String userdepartment) {
		UserList users=UserList.getUserList();

		User newuser=new User(userid,username,userdepartment);
		if(users.set(newuser))
			return true;
		return false;
	}

	/**
	 * 查询员工
	 */
	public UserList getAllUser(){
		UserList users=UserList.getUserList();
		return users;
	}

}
