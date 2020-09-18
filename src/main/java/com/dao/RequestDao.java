package com.dao;

import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.HibernateTemplate;
import com.dto.Requests;

public class RequestDao {
	public int registerRequest(Requests req) {		
		return HibernateTemplate.addObject(req);
	}

	public List<Requests> getAllRequests() {
		List<Requests> reqs=(List)HibernateTemplate.getObjectListByQuery("From Requests");
		return reqs;	
	}
	public void deleteReq(Requests req) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.delete(req); //insert query
		Transaction tx = session.beginTransaction();
		tx.commit(); //permanent save
		session.close();
	}

	public Requests getRequest(int requestId) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();	
		Requests req = (Requests) session.get(Requests.class, requestId);		
		System.out.println("Inside DAO  :"+ req); 
		return req;
	}
	
   
        
    
}
