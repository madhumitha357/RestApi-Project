package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.HibernateTemplate;
import com.dto.Complaints;
import com.dto.NoticeBoard;
import com.dto.Payment;
import com.dto.Requests;
import com.dto.Vacancy;

public class VacancyDao {
	public int addVacancy(Vacancy notice) {		
		return HibernateTemplate.addObject(notice);
	}

	public List<Vacancy> getAllVacancies() {
		List<Vacancy> notices=(List)HibernateTemplate.getObjectListByQuery("From Vacancy");
		return notices;	
	}
	public void delVacancy(Vacancy notice) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.delete(notice); //insert query
		Transaction tx = session.beginTransaction();
		tx.commit(); //permanent save
		session.close();
	}
	public Vacancy getVacancy(int id) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();	
		Vacancy not = (Vacancy) session.get(Requests.class, id);		
		System.out.println("Inside DAO  :"+ not); 
		return not;
	}
}
