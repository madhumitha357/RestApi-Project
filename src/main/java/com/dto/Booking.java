package com.dto;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames= {"amenityId","slotId","date"}))
public class Booking {
	@Id@GeneratedValue
	private int bookingId;
	@FutureOrPresent
	private Date date;
	private String startingtime;
	private String endingtime;

	//private double price;
	@ManyToOne
	@JoinColumn(name="residentId")
	Resident resident;
    

	
	@ManyToOne
	@JoinColumn(name="amenityId")
	Amenity amenity;
	
	
    @ManyToOne
	@JoinColumn(name="slotId")
	Slot slot;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartingtime() {
		return startingtime;
	}

	public void setStartingtime(String startingtime) {
		this.startingtime = startingtime;
	}

	public String getEndingtime() {
		return endingtime;
	}

	public void setEndingtime(String endingtime) {
		this.endingtime = endingtime;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Amenity getAmenity() {
		return amenity;
	}

	public void setAmenity(Amenity amenity) {
		this.amenity = amenity;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}


	

}
