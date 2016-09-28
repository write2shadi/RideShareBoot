package mum.ea.domain.validator;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mum.ea.domain.RideInfo;
import mum.ea.domain.UserCreateForm;
import mum.ea.service.RideInfoService;
import mum.ea.service.UserService;

@Component
public class RideInfoFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RideInfoFormValidator.class);



    @Autowired
    RideInfoService rideInfoService;

    @Autowired
    public RideInfoFormValidator(RideInfoService rideInfoService) {
        this.rideInfoService = rideInfoService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(RideInfo.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        RideInfo form = (RideInfo) target;
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpStreet", "error.pickUpStreet", "Pick Up Street is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpCity", "error.pickUpCity", "Pick Up City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpState", "error.pickUpState", "Pick Up State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dropOffStreet", "error.dropOffStreet", "Drop Off Street name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dropOffCity", "error.dropOffCity", "Drop Off City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dropOffState", "error.dropOffState", "Drop Off State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpDate", "error.pickUpDate", "Pick Up Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpTime", "error.pickUpTime", "Pick Up Time is required.");
		
		if(form.getPickUpDate()==null){
			  errors.reject("error.pickUpDate", "Pick Up Date must be valid.");
		}
		if(form.getPickUpTime()==null){
			  errors.reject("error.pickUpTime", "Pick Up Time must be valid.");
		}
    }


}
