package com.zhuxinquan.service;

import com.zhuxinquan.dao.UserDao;
import com.zhuxinquan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuxinquan on 16-12-12.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean delete(int id) {
        return userDao.delete(id);
    }

    public boolean save(User user) {
        return userDao.save(user);
    }

    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }
}
