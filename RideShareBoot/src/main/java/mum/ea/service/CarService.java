package mum.ea.service;

import java.util.List;

import mum.ea.domain.Car;

import mum.ea.domain.User;

public interface CarService 
{
	public List<Car> getAllCars();	

	public void addCar(Car car);
}
