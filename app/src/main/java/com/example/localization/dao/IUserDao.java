package com.example.localization.dao;

import com.example.localization.pojo.User;

import java.util.List;

public interface IUserDao {
    /**
     *添加用户
     * @param user
     * @return
     */
    long addUser(User user);
    /**
     *删除用户
     * @param id
     * @return
     */
    int delUserById(int id);
    /**
     *更改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     *查询用户信息
     * @param
     * @return
     */
    User getUserById(String userName,String userPass);
    /**
     *全部用户信息
     * @param
     * @return
     */
    List<User> listAllUser();
}
