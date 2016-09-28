package mum.ea.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mum.ea.domain.CurrentUser;
import mum.ea.domain.RideInfo;
import mum.ea.domain.User;
import mum.ea.repository.RideInfoRepository;

@Service
public class RideInfoServiceImpl implements RideInfoService {

  private final RideInfoRepository rideInfoRepository;
 
    @Autowired
    public RideInfoServiceImpl(RideInfoRepository rideInfoRepository) {
        this.rideInfoRepository = rideInfoRepository;
        
    }
        

	public List<RideInfo> getAllRideInfos() {
		return rideInfoRepository.findAll();
	}



	public void addRideInfo(RideInfo rideinfo) {
		
		User u =  ((CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() ;
		rideinfo.setUser(u);
		rideInfoRepository.save(rideinfo);
	     

	}
}
