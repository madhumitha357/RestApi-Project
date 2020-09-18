package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Complaints;
import com.dto.Payment;
import com.dto.Resident;

public class ComplaintsDao {
	public int register(Complaints complaint) {		
		return HibernateTemplate.addObject(complaint);
	}

	public Complaints getComplaints(int complaintId) {
		return (Complaints)HibernateTemplate.getObject(Complaints.class,complaintId);
	}

	public List<Complaints> getAllComplaints() {
		List<Complaints> complaints=(List)HibernateTemplate.getObjectListByQuery("From Complaints");
		return complaints;	
	}

	public List<Complaints> getAmenityByName(String complaintName) {	
		return (List)HibernateTemplate.getObjectListByName(Payment.class,"complaintName",complaintName);
	}
	public int registerComplaint(Complaints complaint) {
		return HibernateTemplate.addObject(complaint);
	}
}
