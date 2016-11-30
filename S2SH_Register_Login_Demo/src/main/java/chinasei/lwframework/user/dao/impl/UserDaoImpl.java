package chinasei.lwframework.user.dao.impl;

import chinasei.lwframework.user.dao.IUserDao;
import chinasei.lwframework.user.model.Users;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;
import java.util.UUID;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
	public void save(Users user) throws Exception {
		String uId = UUID.randomUUID().toString();
		user.setId(uId);
		getHibernateTemplate().save(user);
	}
	public List<Users> findAll() throws Exception {
		String hql = "FROM Users";
		List<Users> userList = (List<Users>) getHibernateTemplate().find(hql);
		return userList;
	}
	public Users getByName(String userName) throws Exception {
		String hql = "FROM Users WHERE name=?";
		Session session = null;
		Users user = null;
		try {
			session = getSession();
			user = (Users)session.createQuery(hql).setParameter(0, userName).uniqueResult();
		} finally {
			releaseSession(session);
		}
		return user;
	}
	public Users getByNameAndPwd(String userName, String userPwd) throws Exception {
		String hql = "FROM Users WHERE name=? AND password=?";
		Session session = null;
		Users user = null;
		try {
			session = getSession();
			user = (Users)session.createQuery(hql)
						.setParameter(0, userName)
						.setParameter(1, userPwd)
						.uniqueResult();
		} finally {
			releaseSession(session);
		}
		return user;
	}
	
}
