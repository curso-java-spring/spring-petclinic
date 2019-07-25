package org.springframework.samples.petclinic.plant;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.sensor.HumiditySensor;

@Entity
@Table(name = "plants")
public class Plant extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity_maximum")
	private int humidity_maximum;

	@Column(name = "humidity_minimum")
	private int humidity_minimum;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
    private Set<HumiditySensor> sensors;
	
	@Column(name = "message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getHumidity_maximum() {
		return humidity_maximum;
	}

	public void setHumidity_maximum(int humidity_maximum) {
		this.humidity_maximum = humidity_maximum;
	}

	public int getHumidity_minimum() {
		return humidity_minimum;
	}

	public void setHumidity_minimum(int humidity_minimum) {
		this.humidity_minimum = humidity_minimum;
	}
	
	public Set<HumiditySensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<HumiditySensor> sensors) {
		this.sensors = sensors;
	}

	@Override
	public String toString() {
		return "Plant [humidity_maximum=" + humidity_maximum + ", humidity_minimum=" + humidity_minimum + ", sensors="
				+ sensors + ", message=" + message + "]";
	}
	
	
}