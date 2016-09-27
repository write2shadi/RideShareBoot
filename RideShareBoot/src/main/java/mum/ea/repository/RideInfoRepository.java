package mum.ea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.ea.domain.RideInfo;

import java.util.Optional;

public interface RideInfoRepository extends JpaRepository<RideInfo, Long> {
    
}
