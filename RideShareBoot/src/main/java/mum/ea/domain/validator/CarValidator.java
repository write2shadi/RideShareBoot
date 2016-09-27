package mum.ea.domain.validator;

import mum.ea.domain.Car;
import mum.ea.domain.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CarValidator implements Validator {

	public boolean supports(Class clazz) {
		return Car.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carMake", "error.carMake", "Car Make is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carModel", "error.carModel", "Car Model is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carYear", "error.carYear", "Car Year is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carColor", "error.carColor", "Car Color name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carType", "error.carType", "Car Type is required.");
	}
}
