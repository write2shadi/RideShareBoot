package mum.ea.domain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
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
    }


}
