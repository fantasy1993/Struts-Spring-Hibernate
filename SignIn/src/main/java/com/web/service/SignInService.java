package com.web.service;

/**
 * Created by zhuxinquan on 6/13/17.
 */
public interface SignInService {
    public void insertSignInRecoder(int uid);
    public int countCurDateNormal();
    public int countCurDateLeave();
    public boolean querySignIn(int uid);
}
