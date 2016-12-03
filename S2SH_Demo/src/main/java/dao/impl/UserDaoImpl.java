package dao.impl;


import dao.IUserDao;
import model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;
import java.util.UUID;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
	public void save(Users user) throws Exception {
		System.out.println("UserDao Save()");
		String uId = UUID.randomUUID().toString();
		user.setId(uId);
		System.out.println(user);
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		if(session.isOpen()){
			session.close();
		}
//		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
//		hibernateTemplate.save(user);
//		hibernateTemplate.flush();
		System.out.println("Save OK");
	}
	public List<Users> findAll() throws Exception {
		String hql = "FROM Users";

//		Session session = null;
//		Users user = null;
//		try {
//			session = getSessionFactory().openSession();
//			Transaction transaction = session.beginTransaction();
//			user = session.find(hql);
//			transaction.commit();
//		} finally {
//			session.close();
//		}
		System.out.println("UserDao findAll()");
		///////////////////
		List<Users> userList = null;
		try{
			userList = (List<Users>) this.getHibernateTemplate().find(hql);
		}catch (Exception e){
			e.printStackTrace();
		}

//		List<Users> userList = getHibernateTemplate().find(hql);
		System.out.println(userList);
		return userList;
	}
	public Users getByName(String userName) throws Exception {
		String hql = "FROM Users WHERE name=?";
		Session session = null;
		Users user = null;
		try {
			session = getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			//数据库暂时为设置主键，存在多个用户名相同的情况，此处仅仅判断是否已被占用，返回一个即可证明已经占用
			user = (Users)session.createQuery(hql).setParameter(0, userName).list().get(0);
			transaction.commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		System.out.println("Check return User: " + user);
		return user;
	}

	public Users getByNameAndPwd(String userName, String userPwd) throws Exception {
		String hql = "FROM Users WHERE name=? AND password=?";
		Session session = null;
		Users user = null;
		try {
			session = getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			user = (Users)session.createQuery(hql)
						.setParameter(0, userName)
						.setParameter(1, userPwd)
						.uniqueResult();
			transaction.commit();
			System.out.println("getByNameAndPwd" + user);
		} finally {
			session.close();
		}
		return user;
	}
	
}
