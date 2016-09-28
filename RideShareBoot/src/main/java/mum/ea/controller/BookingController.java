package mum.ea.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator; 
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.Booking;
import mum.ea.domain.Car;
import mum.ea.domain.CurrentUser;
import mum.ea.domain.RideInfo;
import mum.ea.domain.User;
import mum.ea.domain.validator.BookingInfoValidator;
import mum.ea.domain.validator.BookingInfoValidator;
import mum.ea.service.BookingService;
import mum.ea.service.RideInfoService;


@Controller

public class BookingController {
	
	BookingService bookingService;
	RideInfoService rideInfoService;

	private BookingInfoValidator validator;

	//Bind custom validator for submitted form
	@Autowired

	public BookingController(BookingService bookingService, RideInfoService rideInfoService, BookingInfoValidator validator){
		this.bookingService = bookingService;
		this.validator = validator;
		this.rideInfoService = rideInfoService;
	}
	
	
	//  Bind all bookings list
	 
	/*@RequestMapping(value = "/bookings",  method = RequestMethod.GET)
    public ModelAndView populateBookings() 
    {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ModelAndView("bookings/list","allBookings",bookings);
    }
	
	@RequestMapping(value = "/bookings/add",  method = RequestMethod.GET)
	public ModelAndView setupForm() 
	{
		Booking booking = new Booking();		
		return new ModelAndView("bookings/add", "form", booking);
	}*/

	// ride id is passed
	 @RequestMapping("/bookings/book/{id}")
	 public String bookRide(@PathVariable Integer id) {
		
		 // get current logged in user
			User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
		    RideInfo r = rideInfoService.getRideInfoById(id);
		    
		    Booking b = new Booking();
		    b.setRide(r);
		    b.setUser(u);
		    
			bookingService.addBooking(b);
			 return "redirect:/";
	 
	 }

	
	/*  @RequestMapping(value = "/bookings/add", method = RequestMethod.POST)
	    public String handleUserCreateForm(@Valid @ModelAttribute("form") Booking form, BindingResult bindingResult) {
	        
	        if (bindingResult.hasErrors()) {
	            // failed validation
	            return "bookings/add";
	        }
	       
	       
	        bookingService.addBooking(form);


	       
	        return "redirect:/bookings";
	    }*/
	    
	
	
       
    
    
	
	

}
