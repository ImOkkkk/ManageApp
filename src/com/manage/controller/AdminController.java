package com.manage.controller;

import com.manage.domain.AdminList;
/**
 * 管理员controller
 * @author hcq
 *
 */
public class AdminController {


	//检查用户和密码是否正确
	public boolean checkAdmin(String adminName, String adminPwd) {
		AdminList admins=AdminList.getAdminList();         
		if(admins.check(adminName,adminPwd))
			return true;
		return false;
	}
}
