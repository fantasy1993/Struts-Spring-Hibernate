package chinasei.lwframework.user.dao;

import chinasei.lwframework.user.model.Users;

import java.util.List;

public interface IUserDao {
	void save(Users user) throws Exception;
	List<Users> findAll() throws Exception;
	Users getByName(String userName) throws Exception;
	Users getByNameAndPwd(String userName, String userPwd) throws Exception;
}
