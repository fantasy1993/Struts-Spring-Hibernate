package com.chinasei.hibernate.dao;


import com.chinasei.hibernate.mode.School;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * Data access object (DAO) for domain model class Users.
 * @author MyEclipse - Hibernate Tools
 */
public class SchoolDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SchoolDAO.class);

    
    public List findByExample(School instance) {
        log.debug("finding Users instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.chinasei.hibernate.mode.School")
                    .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    
    public void delete(School persistentInstance) {
        log.debug("deleting Users instance");
        Session session = getSession();
        Transaction tx = null;
        try {
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
    public School findById( int id) {
        log.debug("getting Users instance with id: " + id);
        try {
        	School instance = (School) getSession()
                    .get("com.chinasei.hibernate.mode.School", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
 }

}