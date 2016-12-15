package com.zhuxinquan.service;

import com.zhuxinquan.baseTest.SpringTestCase;
import com.zhuxinquan.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhuxinquan on 16-12-12.
 */

public class UserServiceTest extends SpringTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void selectUserByIdTest(){
//        User user = userService.selectUserById(2);
//        System.out.println(userService.delete(1));
//        User u = new User();
//        u.setUserName("朱新全");
//        u.setUserPassword("1234123");
//        System.out.println(userService.save(u));
        System.out.println(userService.findAll());
//        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }
}
