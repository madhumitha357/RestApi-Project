package com.dao;

import java.util.List;


import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.HibernateTemplate;
import com.dto.Booking;
import com.dto.Requests;
import com.dto.Resident;

public class BookingDao {
	
   private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}

	
	public int bookAmenity(Booking booking) {
		return HibernateTemplate.addObject(booking);
	}

	public List<Booking> getAllBookings() {
		List<Booking> bookings=(List)HibernateTemplate.getObjectListByQuery("From Booking");
		System.out.println("Inside All Booking ..."+bookings);
		return bookings;	
	}
	public Booking getBookingById(int bookingId) {
		System.out.println((Booking)HibernateTemplate.getObjectById(bookingId));
		return (Booking)HibernateTemplate.getObjectById(bookingId);
	}
	public List<Booking> getLastBooking() {
		List<Booking> bookings=(List)HibernateTemplate.getObjectListByQuery("From Booking ORDER BY bookingId DESC LIMIT 1");
		System.out.println("Inside All Booking ..."+bookings);
		return bookings;
	}
	public List<Booking> getMyBooking(int residentId) {
		//List<Booking> bookings=(List)((Query) HibernateTemplate.getObjectListByQuery("From Booking where residentId = :residentId")).setParameter("residentId", residentId);
		//return bookings;
		//String queryString = "From Booking where residentId = :residentId";
		  //Query query = factory.openSession().createQuery(queryString);
		  //query.setInteger("bookingId", bookingId);
		  //Object queryResult = query.uniqueResult();
		  //Booking booking = (Booking)queryResult;
		String queryString = "From Booking where residentId = :residentId";
		 return factory.openSession().createQuery(queryString).setParameter("residentId", residentId).list();
		  
		  
		  
		 
		  
		
		
		
		
	}
	public void deletebook(Booking book) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.delete(book); //insert query
		Transaction tx = session.beginTransaction();
		tx.commit(); //permanent save
		session.close();
	}

	public Booking getbook(int bookingId) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();	
		Booking book = (Booking) session.get(Booking.class, bookingId);		
		System.out.println("Inside DAO  :"+ book); 
		return book;
	}
}
