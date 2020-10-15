package com.jk.service;

import com.jk.pojo.User;

public interface UserService {
    void registUser(User user);

    User login(User user);

    boolean existUsername(String username);

    Integer permission(String username);
}
