package service;

import database.UsersEntity;

import java.util.List;

public interface IUserService {
	void addUser(UsersEntity user) throws Exception;
	UsersEntity getUserByNameAndPassword(String userName, String userPassword) throws Exception;
	boolean isNameValid(String userName) throws Exception;
	List<UsersEntity> findAll() throws Exception;
}
