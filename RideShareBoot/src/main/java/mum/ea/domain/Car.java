package mum.ea.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="carinfo")
public class Car implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer id;
	
	@NotEmpty

	private String carMake = "";
	
	@NotEmpty
	private String carModel = "";
	
	@NotNull
	private Integer carYear = 1970;
	
	@NotEmpty
	private String carColor = "";
	
	@NotEmpty
	private String carType = "";
	
	
	public Car() {}


     
 
    public Car(String carMake) {
        this.carMake = carMake;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getCarYear() {
		return carYear;
	}

	public void setCarYear(Integer carYear) {
		this.carYear = carYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}



	@Override
	public String toString() {
		return "CarVO [id=" + id + ", carMake=" + carMake
				+ ", carModel=" + carModel + ", carYear=" + carYear
			;
	}
}