package mum.ea.domain.validator;

import mum.ea.domain.RideInfo;
import mum.ea.domain.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RideInfoValidator implements Validator {

	public boolean supports(Class clazz) {
		return RideInfo.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpStreet", "error.pickUpStreet", "Pick Up Street is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpCity", "error.pickUpCity", "Pick Up City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpState", "error.pickUpState", "Pick Up State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dropOffStreet", "error.dropOffStreet", "Drop Off Street name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dropOffCity", "error.dropOffCity", "Drop Off City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dropOffState", "error.dropOffState", "Drop Off State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pickUpDate", "error.pickUpDate", "Pick UpDate is required.");
	}
}
