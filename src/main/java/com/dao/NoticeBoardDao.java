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

public class NoticeBoardDao {
	public int addNotice(NoticeBoard notice) {		
		return HibernateTemplate.addObject(notice);
	}

	public List<NoticeBoard> getAllNotices() {
		List<NoticeBoard> notices=(List)HibernateTemplate.getObjectListByQuery("From NoticeBoard");
		return notices;	
	}
	public void deleteNotice(NoticeBoard notice) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.delete(notice); //insert query
		Transaction tx = session.beginTransaction();
		tx.commit(); //permanent save
		session.close();
	}
	public NoticeBoard getNotice(int id) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();	
		NoticeBoard not = (NoticeBoard) session.get(Requests.class, id);		
		System.out.println("Inside DAO  :"+ not); 
		return not;
	}
}
