package chinasei.lwframework.user.service.impl;

import chinasei.lwframework.user.dao.IUserDao;
import chinasei.lwframework.user.model.Users;
import chinasei.lwframework.user.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;

	public void addUser(Users user) throws Exception {
		if(user == null || user.getName() == null || user.getName().equals("")
				|| user.getPassword() == null || user.getPassword().equals("")) {
			return;
		}
		userDao.save(user);
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

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
