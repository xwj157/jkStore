package com.jk.service;

import com.jk.pojo.User;

/**
 * @author xwj157
 * @create 2020-08-10 15:40
 */
public interface UserService {
    public void registUser(User user);

    public User login(User user);

    public boolean existUsername(String username);
}
