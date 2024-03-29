package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.entity.Booking;
import com.jsp.onlinepharmacy.enums.BookingStatus;
import com.jsp.onlinepharmacy.repository.BookingRepo;

@Repository
public class BookingDao {
	@Autowired
	private BookingRepo repo;
	
	public Booking addBooking(Booking booking) {
		return repo.save(booking);
		
	}
	public Booking cancelBooking(int bookingId) {
		Optional<Booking> optional=repo.findById(bookingId);
		if(optional.isPresent()) {
			optional.get().setBookingStatus(BookingStatus.CANCELLED);
			return repo.save(optional.get());
		}
		return null;
	}
	
	public Booking findBookingById(int bookingId) {
		Optional<Booking> optional=repo.findById(bookingId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
}
