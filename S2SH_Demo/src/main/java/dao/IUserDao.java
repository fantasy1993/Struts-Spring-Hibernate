package dao;

import model.Users;

import java.util.List;

/**
 * Created by zhuxinquan on 16-12-1.
 */
public interface IUserDao {
    void save(Users user) throws Exception;
    List<Users> findAll() throws Exception;
    Users getByName(String userName) throws Exception;
    Users getByNameAndPwd(String userName, String userPwd) throws Exception;
}
