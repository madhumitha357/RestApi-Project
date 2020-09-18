package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Amenity;
import com.dto.Payment;

public class PaymentDao {
	public int register(Payment payment) {		
		return HibernateTemplate.addObject(payment);
	}

	public Payment getpayment(int paymenttId) {
		return (Payment)HibernateTemplate.getObject(Payment.class,paymenttId);
	}

	public List<Payment> getAllPayments() {
		List<Payment> payments=(List)HibernateTemplate.getObjectListByQuery("From Payment");
		return payments;	
	}

	public List<Payment> getAmenityByName(String paymentName) {	
		return (List)HibernateTemplate.getObjectListByName(Payment.class,"paymentName",paymentName);
	}
	public int getPaidList() {
		List<Payment> payments=(List)HibernateTemplate.getObjectListByQuery("From Payment where paymentStatus='PAID' ");
	    return payments.size();
	}
	
}
