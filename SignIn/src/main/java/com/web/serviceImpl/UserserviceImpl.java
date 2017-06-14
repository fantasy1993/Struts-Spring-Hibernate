package com.web.serviceImpl;

import com.web.dao.UserDao;
import com.web.model.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuxinquan on 6/6/17.
 */
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public boolean existUser(String username) {
        User user = userDao.existUser(username);
        if(user == null){
            return false;
        }
        return true;
    }

    public int insertUser(User user) {
        userDao.insertUser(user);
        return user.getId();
    }

    public User selectUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    public void updateUserInfo(User user) {
        userDao.updateUserInfo(user);
        return;
    }

    public void updatePaswd(User user) {
        userDao.updatePasswd(user);
    }

    public int countUser(){
        return userDao.countUser();
    }

    public void updateflag(String username) {
        userDao.updateflag(username);
    }
}
