package service.impl;


import dao.IUserDao;
import database.UsersEntity;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;

	public void addUser(UsersEntity user) throws Exception {
		if(user == null || user.getUserName() == null || user.getUserName().equals("")
				|| user.getuPassword() == null || user.getuPassword().equals("")) {
			return;
		}
		userDao.save(user);
	}

	public List<UsersEntity> findAll() throws Exception {
		return userDao.findAll();
	}

	public UsersEntity getUserByNameAndPassword(String userName, String userPassword) throws Exception {
		if(userName == null || userName.trim().equals("")
				|| userPassword == null || userPassword.trim().equals("")) {
			return null;
		}
		return userDao.getByNameAndPwd(userName, userPassword);
	}

	public boolean isNameValid(String userName) throws Exception {
		UsersEntity user = userDao.getByName(userName);
		if(user == null) {
			return true;
		} else {
			return false;
		}
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
