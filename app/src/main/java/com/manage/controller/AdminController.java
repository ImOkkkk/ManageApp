package com.manage.controller;

import com.manage.service.AdminService;

/**
 * 管理员controller
 * @author hcq
 *
 */
public class AdminController {


	//检查用户和密码是否正确
	public boolean checkAdmin(String adminName, String adminPwd) {
		AdminService adminService=new AdminService();
		if(adminService.check(adminName,adminPwd))
			return true;
		return false;
	}
}
