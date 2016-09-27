package mum.ea.service;

import java.util.List;

import mum.ea.repository.CarRepository;
import mum.ea.repository.UserRepository;
import mum.ea.domain.Car;
import mum.ea.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}



	public void addCar(Car car) {
		
		   
	     carRepository.save(car);
	     

	}
}
