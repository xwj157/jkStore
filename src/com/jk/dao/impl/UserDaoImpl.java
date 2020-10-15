package com.jk.dao.impl;

import com.jk.dao.UserDao;
import com.jk.pojo.User;

public class UserDaoImpl extends BaseDAO implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email`,`permission` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`,`permission`) values (?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPermission());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`permission` from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public Integer queryUserPermission(String username) {
        String sql = "select `permission` from t_user where username = ?" ;
        return (Integer) queryForSingleValue(sql,username);
    }


}
