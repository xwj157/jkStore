package com.jk.test;

import com.jk.dao.JKDao;
import com.jk.dao.UserDao;
import com.jk.dao.impl.JKDaoImpl;
import com.jk.dao.impl.UserDaoImpl;
import com.jk.pojo.JK;
import com.jk.pojo.User;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @author xwj157
 * @create 2020-10-06 14:44
 */
public class test {

    UserDao userDao = new UserDaoImpl();
    JKDao jkDao = new JKDaoImpl();
    @Test
    public void test(){

        User user = userDao.queryUserByUsername("root");
        User user1 = userDao.queryUserByUsernameAndPassword("root", "root");
        User user2 = new User();
        user2.setUsername("xwj157");
        user2.setPassword("123456");
        userDao.saveUser(user2);
        System.out.println(user);
        System.out.println(user1);
    }

    @Test
    public void test1(){
        List<JK> jks = jkDao.queryForPageItems(0, 4);
        for(JK jk:jks){
            System.out.println(jk);
        }
    }
}
