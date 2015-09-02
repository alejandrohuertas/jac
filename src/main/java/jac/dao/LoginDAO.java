package jac.dao;

import jac.login.Login;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO extends HibernateDaoSupport {
	@Autowired
	Logger logger;
	
	@Resource(name = "sessionFactory")
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	public Login getLoginByUsername(String username) throws HibernateException{
		
		Session session = null;
		
		try{
			session = this.getSession();
			Criteria criteria = session.createCriteria(Login.class);
			criteria.add(Restrictions.eq("username", username));
			
			Login login = (Login) criteria.uniqueResult();
			
			return login;
		}
		catch (Exception e){
			logger.error("Error accesing Database ", e);
			throw new HibernateException(e.getMessage(),e );
		}
	}

	
	
	
}
