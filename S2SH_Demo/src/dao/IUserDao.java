package dao;

import database.UsersEntity;

import java.util.List;

public interface IUserDao {
	void save(UsersEntity user) throws Exception;
	List<UsersEntity> findAll() throws Exception;
	UsersEntity getByName(String userName) throws Exception;
	UsersEntity getByNameAndPwd(String userName, String userPwd) throws Exception;
}
