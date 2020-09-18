package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Slot;

public class SlotDao {
	
	public int registerslot(Slot slot) {
		return HibernateTemplate.addObject(slot);
	}

	public List<Slot> getAllSlots() {
		List<Slot> slots=(List)HibernateTemplate.getObjectListByQuery("From Slot");
		System.out.println("Inside All Booking ..."+slots);
		return slots;	
	}
}
