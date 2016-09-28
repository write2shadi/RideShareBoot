package mum.ea.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name="RideInfo")
public class RideInfo implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer rideId;
	
	@ManyToOne
	private User user;
	
	@NotEmpty
	private String pickUpStreet = "";
	@NotEmpty
	private String pickUpCity = "";
	@NotEmpty
	private String pickUpState = "";

	private String pickUpZip = "";
	@NotEmpty
	private String dropOffStreet = "";
	@NotEmpty
	private String dropOffCity = "";
	@NotEmpty
	private String dropOffState = "";

	private String dropOffZip = "";
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pickUpDate=new Date();
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	private Date pickUpTime=new Date();
	
	
	public RideInfo() {}
	 
     
 



	public User getUser() {
		return user;
	}






	public void setUser(User user) {
		this.user = user;
	}






	public Integer getRideId() {
		return rideId;
	}



	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}



	public String getPickUpStreet() {
		return pickUpStreet;
	}



	public void setPickUpStreet(String pickUpStreet) {
		this.pickUpStreet = pickUpStreet;
	}



	public String getPickUpCity() {
		return pickUpCity;
	}



	public void setPickUpCity(String pickUpCity) {
		this.pickUpCity = pickUpCity;
	}



	public String getPickUpState() {
		return pickUpState;
	}



	public void setPickUpState(String pickUpState) {
		this.pickUpState = pickUpState;
	}



	public String getPickUpZip() {
		return pickUpZip;
	}



	public void setPickUpZip(String pickUpZip) {
		this.pickUpZip = pickUpZip;
	}



	public String getDropOffStreet() {
		return dropOffStreet;
	}



	public void setDropOffStreet(String dropOffStreet) {
		this.dropOffStreet = dropOffStreet;
	}



	public String getDropOffCity() {
		return dropOffCity;
	}



	public void setDropOffCity(String dropOffCity) {
		this.dropOffCity = dropOffCity;
	}



	public String getDropOffState() {
		return dropOffState;
	}



	public void setDropOffState(String dropOffState) {
		this.dropOffState = dropOffState;
	}



	public String getDropOffZip() {
		return dropOffZip;
	}



	public void setDropOffZip(String dropOffZip) {
		this.dropOffZip = dropOffZip;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Date getPickUpDate() {
		return pickUpDate;
	}



	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}



	public Date getPickUpTime() {
		return pickUpTime;
	}



	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	
	




	@Override
	public String toString() {
		return "RideInfo [rideId=" + rideId + ", pickUpStreet=" + pickUpStreet + ", pickUpCity=" + pickUpCity
				+ ", pickUpState=" + pickUpState + ", pickUpZip=" + pickUpZip + ", dropOffStreet=" + dropOffStreet
				+ ", dropOffCity=" + dropOffCity + ", dropOffState=" + dropOffState + ", dropOffZip=" + dropOffZip
				+ ", pickUpDate=" + pickUpDate + ", pickUpTime=" + pickUpTime + "]";
	}



//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}






}