package com.chinasei.struts1.user.service.impl;

import com.chinasei.struts1.user.Model.Users;
import com.chinasei.struts1.user.dao.IUserDao;
import com.chinasei.struts1.user.dao.impl.UserDaoImpl;
import com.chinasei.struts1.user.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
	private static IUserDao userDao = new UserDaoImpl();

	public int addUser(Users user) throws Exception {
		if(user == null || user.getName() == null || user.getName().equals("")
				|| user.getPassword() == null || user.getPassword().equals("")) {
			return 0;
		}
		return userDao.save(user);
	}

	public List<Users> findAll() throws Exception {
		return userDao.findAll();
	}

	public Users getUserByNameAndPassword(String userName, String userPassword) throws Exception {
		if(userName == null || userName.trim().equals("")
				|| userPassword == null || userPassword.trim().equals("")) {
			return null;
		}
		return userDao.getByNameAndPwd(userName, userPassword);
	}

	public boolean isNameValid(String userName) throws Exception {
		Users user = userDao.getByName(userName);
		if(user == null) {
			return true;
		} else {
			return false;
		}
	}

}
