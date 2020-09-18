package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Amenity;
import com.dto.Apartment;

public class AmenityDao {
	public int register(Amenity amenity) {		
		return HibernateTemplate.addObject(amenity);
	}

	public Amenity getAmenity(int amenityId) {
		return (Amenity)HibernateTemplate.getObject(Amenity.class,amenityId);
	}

	public List<Amenity> getAllAmenities() {
		List<Amenity> amenities=(List)HibernateTemplate.getObjectListByQuery("From Amenity");
		return amenities;	
	}

	public List<Amenity> getAmenityByName(String amenityName) {	
		return (List)HibernateTemplate.getObjectListByName(Amenity.class,"amenityName",amenityName);
	}
}
