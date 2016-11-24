package com.chinasei.struts1.user.dao.impl;

import com.chinasei.struts1.db.utils.DbUtils;
import com.chinasei.struts1.user.Model.Users;
import com.chinasei.struts1.user.dao.IUserDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UserDaoImpl implements IUserDao {
	public int save(Users user) throws Exception {
		String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(user.getId());		
		paramList.add(user.getName());
		paramList.add(user.getPassword());
		paramList.add(user.getEmail());
		int result = DbUtils.execute(sql, paramList);
		if(result == 1) {
			user = getByName(user.getName());
		}
		return result;
	}
	
	public List<Users> findAll() throws Exception {
		String sql = "SELECT * FROM USERS";
		List<Users> userList = getUserList(sql, null);
		return userList;
	}

	public Users getByName(String userName) throws Exception {
		String sql = "SELECT * FROM USERS WHERE USER_NAME=?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(userName.trim());
		List<Users> userList = getUserList(sql, paramList);
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}

	public Users getByNameAndPwd(String userName, String userPwd) throws Exception {
		String sql = "SELECT * FROM USERS WHERE USER_NAME=? AND U_PASSWORD=?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(userName.trim());
		paramList.add(userPwd.trim());
		List<Users> userList = getUserList(sql, paramList);
		if(userList.isEmpty()) {
			return null;
		}
//		System.out.println(userList.get(0).getEmail());
		return userList.get(0);
	}
	
	private List<Users> getUserList(String sql, List<Object> paramList) throws Exception {
		List<Users> userList = new ArrayList<Users>();
		List<Map<String, String>> userMapList = DbUtils.getQueryList(sql, paramList);
		if(userMapList == null || userMapList.isEmpty()) {
			return userList;
		}

//		System.out.println("UserMapList:" + userMapList);

		for (Map<String, String> userMap : userMapList) {
			Iterator<Entry<String, String>> userEntryIt = userMap.entrySet().iterator();
			Users user = new Users();
			while (userEntryIt.hasNext()) {
				Entry<String, String> userEntry = userEntryIt.next();
				if(userEntry.getKey().equals("id")) {
					user.setId(userEntry.getValue());
				} else if(userEntry.getKey().equals("user_name")) {
					user.setName(userEntry.getValue());
				} else if(userEntry.getKey().equals("u_password")) {
					user.setPassword(userEntry.getValue());
				} else if(userEntry.getKey().equals("u_email")) {
					user.setEmail(userEntry.getValue());
				}
			}
			userList.add(user);
		}
		return userList;
	}

}
