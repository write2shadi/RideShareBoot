package mum.ea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.ea.domain.Car;
import mum.ea.domain.User;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    
}
