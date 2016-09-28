package mum.ea.domain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mum.ea.domain.Booking;
import mum.ea.domain.Car;
import mum.ea.domain.UserCreateForm;
import mum.ea.service.BookingService;
import mum.ea.service.CarService;
import mum.ea.service.UserService;

@Component
public class BookingInfoValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingInfoValidator.class);



   @Autowired
	BookingService bookingService;

    @Autowired
    public BookingInfoValidator(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Booking.class); //support takes any kind of class for validation 
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        Booking form = (Booking) target;
    }


}
