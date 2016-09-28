package mum.ea.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import mum.ea.domain.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "firstname")
	private String firstName;
    @Column(name = "lastname")
	private String lastName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	@Column(name = "city")
	private String city;
	private String state;
	private String zipCode;	


	
	
	
	@OneToMany(mappedBy="user")
	private List<Car> carInfos = new ArrayList<Car>();
	
	@OneToMany(mappedBy="user")
	private List<RideInfo> rideinfos = new ArrayList<RideInfo>();
	
	//@OneToMany(mappedBy="user")
	// private List<Booking> bookings = new ArrayList<Booking>();
	
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email.replaceFirst("@.*", "@***") +
                ", passwordHash='" + passwordHash.substring(0, 10) +
                ", role=" + role +
                '}';
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	



	public List<Car> getCarInfos() {
		return carInfos;
	}

	public void setCarInfos(List<Car> carInfos) {
		this.carInfos = carInfos;
	}

	public List<RideInfo> getRideinfos() {
		return rideinfos;
	}

	public void setRideinfos(List<RideInfo> rideinfos) {
		this.rideinfos = rideinfos;
	}
}
