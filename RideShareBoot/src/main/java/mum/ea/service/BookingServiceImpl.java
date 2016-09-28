package mum.ea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mum.ea.domain.Booking;

import mum.ea.repository.BookingRepository;
import mum.ea.repository.CarRepository;

@Service
public class BookingServiceImpl implements BookingService {

	 private final BookingRepository bookingRepository;

	    @Autowired
	    public BookingServiceImpl(BookingRepository bookingRepository) {
	        this.bookingRepository = bookingRepository;
	    }

	
       @Override
		public void addBooking(Booking booking) {
			bookingRepository.save(booking);
			
		}

		@Override
		public List<Booking> getAllBookings() {
			return bookingRepository.findAll();
			
		}
	}