package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jvnet.hk2.annotations.Service;

import com.dto.Resident;
import com.db.HibernateTemplate;

@Service
public class ResidentDao {
	private SessionFactory factory = null;

	public Resident getResByUserPass(String loginId,String password) {

		return (Resident)HibernateTemplate.getObjectByUserPass(loginId,password);
	}

	public int register(Resident resident) {
		return HibernateTemplate.addObject(resident);
	}

	public List<Resident> getAllResidents() {
		List<Resident> residents=(List)HibernateTemplate.getObjectListByQuery("From Resident");
		System.out.println("Inside All Residents ..."+residents);
		return residents;	
	}

	public Resident getResident(int id) {
		return (Resident)HibernateTemplate.getObject(Resident.class,id);
	}


	public void getResidents(int loginId) {
		String query= "from Resident where loginId = :loginId";

		System.out.println("get Residents is called...");
		List<Object> obj = (List<Object>) HibernateTemplate.getObjectListByQuery(query);
		System.out.println("Testing get Residents :" + obj); 
		for(Object res: obj){
			Resident resident = (Resident)res;
			System.out.println(resident.getResidentName());
		}
	}
	public static Resident findByEmail(String email) {
		System.out.println((Resident)HibernateTemplate.getObjectByEmail(email));
		return (Resident)HibernateTemplate.getObjectByEmail(email);
	}

	public Resident getResByloginId(String loginId) {
		System.out.println((Resident)HibernateTemplate.getObjectByloginId(loginId));
		return (Resident)HibernateTemplate.getObjectByloginId(loginId);
	}
	public void update(Resident resident) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.saveOrUpdate(resident);
		Transaction tx = session.beginTransaction();
		tx.commit(); //permanent save
		session.close();
	}
}
