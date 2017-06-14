package com.web.dao;

import com.web.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuxinquan on 6/6/17.
 */
@Repository("UserDao")
public interface UserDao {

    public User selectUserByUsername(String username);

    public int insertUser(User user);

    public User existUser(String username);

    public void updateUserInfo(User user);

    public void updatePasswd(User user);

    public int countUser();

    public void updateflag(String username);

}
