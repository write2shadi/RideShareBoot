package mum.ea.service;

import java.util.List;

import mum.ea.domain.Booking;

public interface BookingService 
{
	public void addBooking(Booking booking);

	public List<Booking> getAllBookings();

}
