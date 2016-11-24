package com.chinasei.hibernate.dao;


import com.chinasei.hibernate.mode.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * Data access object (DAO) for domain model class Users.
 * @see com.chinasei.hibernate.mode.Student
 * @author MyEclipse - Hibernate Tools
 */
public class StudentDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(StudentDAO.class);

	//property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";

    
    public void save(Student transientInstance) {
        log.debug("saving Users instance");
        Session session = getSession();
        Transaction tx = null;
        try {
            //getSession().save(transientInstance);
            //log.debug("save successful");        	
    	    tx=session.beginTransaction(); //����ʼ
    	    session.save(transientInstance); //����
    	    tx.commit();    	    
    	    log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            if(tx != null){
            	tx.rollback();
            }
            throw re;
        } finally {
        	session.close();
        }
    }
    
    public void update(Student transientInstance) {
        log.debug("updating Users instance");
        Session session = getSession();
        Transaction tx = null;
        try {
            //getSession().save(transientInstance);
            //log.debug("save successful");        	
    	    tx=session.beginTransaction(); //����ʼ
    	    session.update(transientInstance); //����
    	    tx.commit();    	    
    	    log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            if(tx != null){
            	tx.rollback();
            }
            throw re;
        } finally {
        	session.close();
        }
    }
    
//    public void delete(java.lang.String id){
//		  log.debug("deleting User instance��");
//		  Users user = findById(id);
//		  delete(user);
//    }
    
	public void delete(Student persistentInstance) {
        log.debug("deleting Users instance");
        Session session = getSession();
        Transaction tx = null;
        try {
            //getSession().delete(persistentInstance);
        	 //Session session=getSession();
        	 tx=session.beginTransaction();
        	 session.delete(persistentInstance);
        	 tx.commit();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            if(tx != null){
            	tx.rollback();
            }
            throw re;
        } finally {
        	session.close();
        }
    }
    
    public Student findById( String id) {
        log.debug("getting Users instance with id: " + id);
        try {
        	Student instance = (Student) getSession()
                    .get("com.chinasei.hibernate.Users", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Student instance) {
        log.debug("finding Users instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.chinasei.hibernate.mode.Student")
                    .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Users instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Student as model where model."
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}
	
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}
	
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}
	
	public Student merge(Student detachedInstance) {
        log.debug("merging Users instance");
    	
        try {
        	Student result = (Student) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            System.out.println("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
        	System.out.println("merge failed");
            throw re;
        }
    }
	
//    public Users merge(Users detachedInstance) {
//        log.debug("merging Users instance");
//    	Session session = getSession();
//    	Transaction tx = null;
//        try {
//        	tx=session.beginTransaction();
//        	Users result = (Users) session.merge(detachedInstance);
//        	tx.commit();
//            log.debug("merge successful");
//            session.close();
//            return result;
//        } catch (RuntimeException re) {
//            log.error("merge failed", re);
//            if(tx != null){
//            	tx.rollback();
//            }
//        	session.close();
//            throw re;
//        }
//    }
    
    public void attachDirty(Student instance) {
        log.debug("attaching dirty Users instance");
        try {
        	System.out.print("ok");
            getSession().saveOrUpdate(instance);
            System.out.print("ok1");
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            System.out.print("ok2");
            throw re;
        } 
    }

//    public void attachDirty(Users instance) {
//        log.debug("attaching dirty Users instance");
//        Session session = getSession();
//    	Transaction tx = null;
//        try {
//        	System.out.print("ok");
//        	tx=session.beginTransaction();
//        	System.out.print("ok1");
//        	session.saveOrUpdate(instance);
//        	System.out.print("ok2");
//            tx.commit();
//            System.out.print("ok3");
//            log.debug("attach successful");
//        } catch (RuntimeException re) {
//            log.error("attach failed", re);
//            if(tx != null){
//            	tx.rollback();
//            }
//            throw re;
//        } finally {
//        	System.out.print("ok4");
//        	session.close();
//        }
//    }
    
    public void attachClean(Student instance) {
        log.debug("attaching clean Users instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}