package mum.ea.domain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mum.ea.domain.Car;
import mum.ea.domain.UserCreateForm;
import mum.ea.service.CarService;
import mum.ea.service.UserService;

@Component
public class CarInfoFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarInfoFormValidator.class);



    @Autowired
	CarService carService;

    @Autowired
    public CarInfoFormValidator(CarService carService) {
        this.carService = carService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Car.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        Car form = (Car) target;
    }


}
