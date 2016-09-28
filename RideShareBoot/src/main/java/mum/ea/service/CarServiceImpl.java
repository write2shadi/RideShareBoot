package mum.ea.service;

import java.util.List;

import mum.ea.repository.CarRepository;
import mum.ea.repository.UserRepository;
import mum.ea.domain.Car;
import mum.ea.domain.CurrentUser;
import mum.ea.domain.Role;
import mum.ea.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;
  private final UserRepository userRepository;
    @Autowired
    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository  =userRepository;
    }

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}



	public void addCar(Car car) {
		
		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
		 car.setUser(u);  
		 
	     carRepository.save(car);
	     
	     if(u.getRole() == Role.CUSTOMER){
			 u.setRole(Role.DRIVER);
	        userRepository.save(u);
	     }
	     

	}
}
