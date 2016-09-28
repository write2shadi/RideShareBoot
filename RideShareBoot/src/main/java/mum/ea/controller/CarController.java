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
import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.domain.UserCreateForm;
import mum.ea.domain.validator.CarInfoFormValidator;
import mum.ea.domain.validator.UserCreateFormValidator;
import mum.ea.service.CarService;
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
public class CarController {
	
	CarService carService;
	UserService userService;
	
	private final CarInfoFormValidator carInfoFormValidator;

	@Autowired
	//Bind custom validator for submitted form
	public CarController(CarService carService, UserService userService, CarInfoFormValidator carInfoFormValidator)
	{
		this.carService = carService;
		this.carInfoFormValidator = carInfoFormValidator;
		this.userService = userService;
	}
	

	
	/**
	 * Bind all cars list
	 * */
	@RequestMapping(value = "/cars",  method = RequestMethod.GET)
    public ModelAndView populateCars() 
    {
		List<Car> cars;
		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
		
		if(u.getRole() == Role.ADMIN)
			cars = carService.getAllCars();
		else{
			Optional<User> dbUser = userService.getUserById(u.getId());
			if(dbUser.isPresent())
				cars = dbUser.get().getCarInfos();
			else
				cars = new ArrayList<Car>();
		}
		
        return new ModelAndView("cars/list", "allCars", cars);
    }
	
	
	@InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(carInfoFormValidator);
    }


	  
	/**
	 * Method will be called in initial page load at GET /cars/add
	 * */
	@RequestMapping(value = "/cars/add",  method = RequestMethod.GET)
	public ModelAndView setupForm() 
	{
		Car car = new Car();		
		return new ModelAndView("cars/add", "form", car);
	}


	
    
    @RequestMapping(value = "/cars/add", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") Car form, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            // failed validation
            return "cars/add";
        }
       
       
        carService.addCar(form);


        // ok, redirect
        return "redirect:/cars";
    }
    

}
