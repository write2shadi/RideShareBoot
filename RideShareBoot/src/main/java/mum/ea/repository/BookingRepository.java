package mum.ea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.ea.domain.Booking;
import mum.ea.domain.User;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
