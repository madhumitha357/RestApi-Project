package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Apartment {
	@Id@GeneratedValue
	private int apartmentId;
	private String apartmentName;
	private String location;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy="apartment")
	List<Resident> residentList = new ArrayList<Resident>();

	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	

	public List<Resident> getResidentList() {
		return residentList;
	}

	public void setResidentList(List<Resident> residentList) {
		this.residentList = residentList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
