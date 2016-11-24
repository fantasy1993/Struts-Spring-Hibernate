package com.chinasei.struts1.user.dao;

import com.chinasei.struts1.user.Model.Users;

import java.util.List;

public interface IUserDao {

	int save(Users user) throws Exception;

	List<Users> findAll() throws Exception;
	

	Users getByName(String userName) throws Exception;

	Users getByNameAndPwd(String userName, String userPwd) throws Exception;
}
