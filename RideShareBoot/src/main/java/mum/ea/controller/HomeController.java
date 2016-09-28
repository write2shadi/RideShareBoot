package mum.ea.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.Booking;
import mum.ea.domain.CurrentUser;
import mum.ea.domain.RideInfo;
import mum.ea.domain.RideInfoDisplay;
import mum.ea.domain.User;
import mum.ea.service.RideInfoService;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    RideInfoService rideInfoService;
    
    
    @Autowired
    public HomeController(RideInfoService rideInfoService) {		
		this.rideInfoService = rideInfoService;
	}



	@RequestMapping("/")
    public ModelAndView getHomePage() {
        LOGGER.debug("Getting home page");
        
        ModelAndView mv = new ModelAndView("home");
        
    	// get current logged in user
       
        List<RideInfo> allRideInfos = rideInfoService.getAllRideInfos();
    	List<RideInfoDisplay> allRideInfosDisplay = new ArrayList<RideInfoDisplay>();

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CurrentUser){
		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;	
       
	        for(RideInfo ride : allRideInfos){
	        	RideInfoDisplay rid = new RideInfoDisplay();
	            rid.setRide(ride);
	            
	        	List<Booking> bookings = ride.getBookings();
	          	for(Booking b : bookings){
	          		if(b.getUser().getId() == u.getId())
	          			rid.setBooked(true); 
	          	}
	          		          		       
		        allRideInfosDisplay.add(rid);
	        }
	        
	        mv.addObject("allRideInfos" , allRideInfosDisplay);  
        }else{
        	
        	 for(RideInfo ride : allRideInfos){
 	        	RideInfoDisplay rid = new RideInfoDisplay();
 	            rid.setRide(ride); 	         
 	          		          		       
 		        allRideInfosDisplay.add(rid);
 	        }
        	 
        	 mv.addObject("allRideInfos" , allRideInfosDisplay);
        }
        
       
        
        return mv;
    }

}
