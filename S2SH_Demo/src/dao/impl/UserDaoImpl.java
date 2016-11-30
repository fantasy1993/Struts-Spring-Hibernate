package dao.impl;


import dao.IUserDao;
import database.UsersEntity;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import java.util.List;
import java.util.UUID;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
	public void save(UsersEntity user) throws Exception {
		String uId = UUID.randomUUID().toString();
		user.setId(uId);
		getHibernateTemplate().save(user);
	}
	public List<UsersEntity> findAll() throws Exception {
		String hql = "FROM UsersEntity";
		List<UsersEntity> userList = (List<UsersEntity>) getHibernateTemplate().find(hql);
		return userList;
	}
	public UsersEntity getByName(String userName) throws Exception {
		String hql = "FROM UsersEntity WHERE userName=?";
		Session session = null;
		UsersEntity user = null;
		try {
			session = getSession();
			user = (UsersEntity)session.createQuery(hql).setParameter(0, userName).uniqueResult();
		} finally {
			releaseSession(session);
		}
		return user;
	}
	public UsersEntity getByNameAndPwd(String userName, String userPwd) throws Exception {
		String hql = "FROM UsersEntity WHERE userName=? AND uPassword=?";
		Session session = null;
		UsersEntity user = null;
		try {
			session = getSession();
			user = (UsersEntity)session.createQuery(hql)
						.setParameter(0, userName)
						.setParameter(1, userPwd)
						.uniqueResult();
		} finally {
			releaseSession(session);
		}
		return user;
	}
	
}
