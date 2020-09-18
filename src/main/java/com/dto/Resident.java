package com.dto;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Resident {
	@Id@GeneratedValue
	private int residentId;
	private String residentName;
	private String gender;
	private String mobile;
	private String loginId;
	private String password;
	private String imageurl;
	@Column(unique = true,name = "email")
	private String email;
	
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="apartmentId")
	Apartment apartment;
	
    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "resident")
	List<Payment> paymentList = new ArrayList<Payment>();

	
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resident")
	List<Booking> bookinglist = new ArrayList<Booking>();
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resident")
	List<Service> servicelist = new ArrayList<Service>();
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resident")
	List<Complaints> complaintlist = new ArrayList<Complaints>();


	public int getResidentId() {
		return residentId;
	}


	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}


	public String getResidentName() {
		return residentName;
	}


	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Apartment getApartment() {
		return apartment;
	}


	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}


	public List<Payment> getPaymentList() {
		return paymentList;
	}


	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}


	public List<Booking> getBookinglist() {
		return bookinglist;
	}


	public void setBookinglist(List<Booking> bookinglist) {
		this.bookinglist = bookinglist;
	}

	public List<Service> getServicelist() {
		return servicelist;
	}


	public void setServicelist(List<Service> servicelist) {
		this.servicelist = servicelist;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
}
