package com.web.serviceImpl;

import com.web.dao.SignInDao;
import com.web.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuxinquan on 6/13/17.
 */
@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    SignInDao signInDao;

    public void insertSignInRecoder(int uid) {
        signInDao.insertSignInRecoder(uid);
    }

    public int countCurDateNormal() {
        return signInDao.countCurDateNormal();
    }

    public int countCurDateLeave() {
        return signInDao.countCurDateLeave();
    }

    public boolean querySignIn(int uid) {
        if(signInDao.querySignIn(uid) >= 1){
            return true;
        }
        return false;
    }


}
