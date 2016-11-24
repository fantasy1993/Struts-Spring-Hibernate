package com.chinasei.struts1.user.service;

import com.chinasei.struts1.user.Model.Users;

import java.util.List;

public interface IUserService {
	/**
	 * �����û�
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int addUser(Users user) throws Exception;
	/**
	 * �����û������������û�
	 * @param userName
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	Users getUserByNameAndPassword(String userName, String userPassword) throws Exception;
	/**
	 * �û����Ƿ����
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	boolean isNameValid(String userName) throws Exception;
	/**
	 * ��������û�
	 * @return
	 * @throws Exception
	 */
	List<Users> findAll() throws Exception;
}
