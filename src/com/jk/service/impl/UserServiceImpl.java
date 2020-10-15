package com.jk.service.impl;

import com.jk.dao.UserDao;
import com.jk.dao.impl.UserDaoImpl;
import com.jk.pojo.User;
import com.jk.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }

    @Override
    public Integer permission(String username) {
        return userDao.queryUserPermission(username);
    }
}
