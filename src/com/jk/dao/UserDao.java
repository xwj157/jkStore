package com.jk.dao;

import com.jk.pojo.User;

public interface UserDao {

    public User queryUserByUsername(String username);

    public int saveUser(User user);

    public User queryUserByUsernameAndPassword(String username,String password);

    public Integer queryUserPermission(String username);

}
