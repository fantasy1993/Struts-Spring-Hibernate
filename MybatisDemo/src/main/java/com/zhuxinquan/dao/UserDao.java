package com.zhuxinquan.dao;

import com.zhuxinquan.model.User;

import java.util.List;

/**
 * Created by zhuxinquan on 16-12-12.
 */
public interface UserDao {
    public User selectUserById(Integer userId);
    boolean update(User user);
    boolean delete(int id);
    boolean save(User user);
    List<User> findAll();
}
