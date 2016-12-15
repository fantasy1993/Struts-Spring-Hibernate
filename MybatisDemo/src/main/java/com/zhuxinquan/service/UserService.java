package com.zhuxinquan.service;

import com.zhuxinquan.model.User;

import java.util.List;

/**
 * Created by zhuxinquan on 16-12-12.
 */
public interface UserService {
    List<User> findAll();
    boolean update(User user);
    boolean delete(int id);
    boolean save(User user);
    User selectUserById(Integer userId);
}
