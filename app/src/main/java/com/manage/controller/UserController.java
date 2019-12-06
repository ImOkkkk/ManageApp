package com.manage.controller;

import com.manage.domain.User;
import com.manage.service.UserService;

import java.util.ArrayList;

/**
 * 员工controller
 */
public class UserController {
    UserService userService = new UserService();

    /**
     * 添加员工
     */
    public boolean addUser(String userid, String username, String userdepartment) {
        User newuser = new User(userid, username, userdepartment);
        if (userService.insert(newuser)) {
            return true;
        }
        return false;

    }

    /**
     * 删除员工
     */
    public boolean deleteUser(String name) {
        if (userService.delete(name))
            return true;
        return false;
    }

    /**
     * 修改员工
     */
    public boolean setUser(String userid, String username, String userdepartment) {
        User newuser = new User(userid, username, userdepartment);
        if (userService.set(newuser))
            return true;
        return false;
    }

    /**
     * 查询员工
     */
    public ArrayList<User> getAllUser() {
        return userService.getUserList();
    }

}
