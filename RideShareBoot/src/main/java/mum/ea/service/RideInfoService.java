package mum.ea.service;

import java.util.List;

import mum.ea.domain.RideInfo;


public interface RideInfoService 
{
	public List<RideInfo> getAllRideInfos();	
	public void addRideInfo(RideInfo rideinfo);
	public RideInfo getRideInfoById(Integer id);
}
