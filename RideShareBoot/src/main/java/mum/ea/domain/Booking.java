package mum.ea.domain;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table (name="bookinginfo")
public class Booking implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private RideInfo ride;
	

	
	public Booking() {}
	 


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public RideInfo getRide() {
		return ride;
	}

	public void setRide(RideInfo ride) {
		this.ride = ride;
	}

	
	@Override
	public String toString() {
		return "booking [id=" + id +", user=" + user +",ride="+ride
				;
	}
	
	
	
	
	
	
}