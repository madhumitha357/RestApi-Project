package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jvnet.hk2.annotations.Service;

import com.db.HibernateTemplate;
import com.dto.Apartment;
import com.dto.Resident;

@Service
public class ApartmentDao {
private SessionFactory factory = null;
	
	public int register(Apartment dept) {		
		return HibernateTemplate.addObject(dept);
	}

	public Apartment getApartment(int deptId) {
		return (Apartment)HibernateTemplate.getObject(Apartment.class,deptId);
	}

	public List<Apartment> getAllApartments() {
		List<Apartment> aprts=(List)HibernateTemplate.getObjectListByQuery("From Apartment");
		return aprts;	
	}

	public List<Apartment> getApartmentByName(String deptName) {	
		return (List)HibernateTemplate.getObjectListByName(Apartment.class,"deptName",deptName);
	}
}
