package com.web.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by zhuxinquan on 6/13/17.
 */
@Repository("SignInDao")
public interface SignInDao {
    public void insertSignInRecoder(int uid);
    public int countCurDateNormal();
    public int countCurDateLeave();
    public int querySignIn(int uid);
}
