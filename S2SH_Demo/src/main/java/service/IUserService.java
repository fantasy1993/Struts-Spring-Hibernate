package service;


import model.Users;

import java.util.List;

public interface IUserService {
	void addUser(Users user) throws Exception;
	Users getUserByNameAndPassword(String userName, String userPassword) throws Exception;
	boolean isNameValid(String userName) throws Exception;
	List<Users> findAll() throws Exception;
}
