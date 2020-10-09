package com.jk.dao;

import com.jk.pojo.User;

/**
 * @author xwj157
 * @create 2020-08-10 14:50
 */
public interface UserDao {

    public User queryUserByUsername(String username);

    public int saveUser(User user);

    public User queryUserByUsernameAndPassword(String username,String password);

    public Integer queryUserPermission(String username);

}
