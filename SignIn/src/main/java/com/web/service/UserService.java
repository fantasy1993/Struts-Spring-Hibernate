package com.web.service;

import com.web.model.User;

/**
 * Created by zhuxinquan on 6/6/17.
 */
public interface UserService {
    public boolean existUser(String username);
    public int insertUser(User user);
    public User selectUserByUsername(String username);
    public void updateUserInfo(User user);
    public void updatePaswd(User user);
    public int countUser();
}
