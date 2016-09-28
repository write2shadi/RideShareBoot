package mum.ea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import mum.ea.domain.Car;
import mum.ea.domain.CurrentUser;
import mum.ea.domain.RideInfo;
import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.domain.UserCreateForm;
import mum.ea.domain.validator.RideInfoFormValidator;
import mum.ea.domain.validator.UserCreateFormValidator;
import mum.ea.service.CarService;
import mum.ea.service.RideInfoService;
import mum.ea.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RideInfoController {
	
	RideInfoService rideInfoService;
	UserService userService;

	private final RideInfoFormValidator rideInfoFormValidator;

	@Autowired
	//Bind custom validator for submitted form
	public RideInfoController(RideInfoService rideInfoService, UserService userService,RideInfoFormValidator rideInfoFormValidator)
	{
		this.rideInfoService = rideInfoService;
		this.rideInfoFormValidator = rideInfoFormValidator;
		this.userService = userService;
	}
	

	
	/**
	 * Bind all rideInfos list
	 * */
	@RequestMapping(value = "/rideinfos",  method = RequestMethod.GET)
    public ModelAndView populateRideInfos() 
    {
        List<RideInfo> rideInfos;
        		
		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
		
		if(u.getRole() == Role.ADMIN)
			rideInfos = rideInfoService.getAllRideInfos();
		else{
			Optional<User> dbUser = userService.getUserById(u.getId());
			if(dbUser.isPresent())
				rideInfos = dbUser.get().getRideinfos();
			else
				rideInfos = new ArrayList<RideInfo>();
		}
		
		
         
        
        
        return new ModelAndView("rideinfos/ridelist", "allRideInfos", rideInfos);
    }
	
	
	@InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(rideInfoFormValidator);
    }


	  
	/**
	 * Method will be called in initial page load at GET /rideinfos/add
	 * */
	@RequestMapping(value = "/rideinfos/rideadd",  method = RequestMethod.GET)
	public ModelAndView setupForm() 
	{
		RideInfo rideInfo = new RideInfo();		
		ModelAndView mv = new ModelAndView("/rideinfos/rideadd", "form", rideInfo);
		
		
		// get current logged in user
		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
		
		List<Car> myCars;
		
		Optional<User> dbUser = userService.getUserById(u.getId());
		if(dbUser.isPresent())
			myCars = dbUser.get().getCarInfos();
		else
			myCars = new ArrayList<Car>();
			
		mv.addObject("myCars", myCars);
		return mv;
	}


	
    
    @RequestMapping(value = "/rideinfos/rideadd", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(@Valid @ModelAttribute("form") RideInfo form, BindingResult bindingResult) {
        
    	
		
        if (bindingResult.hasErrors()) {
        	ModelAndView mv = new ModelAndView("/rideinfos/rideadd", "form", form);
    		
    		
    		// get current logged in user
    		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
    		
    		List<Car> myCars;
    		
    		Optional<User> dbUser = userService.getUserById(u.getId());
    		if(dbUser.isPresent())
    			myCars = dbUser.get().getCarInfos();
    		else
    			myCars = new ArrayList<Car>();
    			
    		mv.addObject("myCars", myCars);
    	
    		
            // failed validation
            return mv;
        }
       
       
        rideInfoService.addRideInfo(form);


        // ok, redirect
        return new ModelAndView("redirect:/rideinfos");
    } 
    

}
