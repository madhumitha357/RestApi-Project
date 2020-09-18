package com.dto;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@XmlRootElement
public class Amenity {
	@Id@GeneratedValue
	private int amenityId;
	private String amenityName;
	private double charge;
	private String timing;

	




	public int getAmenityId() {
		return amenityId;
	}


	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}


	public String getAmenityName() {
		return amenityName;
	}


	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}


	public double getCharge() {
		return charge;
	}


	public void setCharge(double charge) {
		this.charge = charge;
	}


	public String getTiming() {
		return timing;
	}


	public void setTiming(String timing) {
		this.timing = timing;
	}


	


	
}
