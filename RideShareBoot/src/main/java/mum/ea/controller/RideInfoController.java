package mum.ea.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import mum.ea.domain.RideInfo;
import mum.ea.domain.UserCreateForm;
import mum.ea.domain.validator.RideInfoFormValidator;
import mum.ea.domain.validator.UserCreateFormValidator;
import mum.ea.service.RideInfoService;
import mum.ea.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
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

	private final RideInfoFormValidator rideInfoFormValidator;

	@Autowired
	//Bind custom validator for submitted form
	public RideInfoController(RideInfoService rideInfoService, RideInfoFormValidator rideInfoFormValidator)
	{
		this.rideInfoService = rideInfoService;
		this.rideInfoFormValidator = rideInfoFormValidator;
	}
	

	
	/**
	 * Bind all rideInfos list
	 * */
	@RequestMapping(value = "/rideinfos",  method = RequestMethod.GET)
    public ModelAndView populateRideInfos() 
    {
        List<RideInfo> rideInfos = rideInfoService.getAllRideInfos();        
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
		return new ModelAndView("/rideinfos/rideadd", "form", rideInfo);
	}


	
    
    @RequestMapping(value = "/rideinfos/rideadd", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") RideInfo form, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            // failed validation
            return "rideinfos/rideadd";
        }
       
       
        rideInfoService.addRideInfo(form);


        // ok, redirect
        return "redirect:/rideinfos";
    }
    

}
