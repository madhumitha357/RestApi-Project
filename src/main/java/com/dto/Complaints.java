package com.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Complaints{
	@Id@GeneratedValue
	private int complaintId;
	private String complaintStatus;
	private String complaintmessage;
	
	@ManyToOne
	@JoinColumn(name="residentId")
	Resident resident;

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public String getComplaintmessage() {
		return complaintmessage;
	}

	public void setComplaintmessage(String complaintmessage) {
		this.complaintmessage = complaintmessage;
	}

	
	

	

	
}