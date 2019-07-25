package org.springframework.samples.petclinic.sensor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.plant.Plant;


@Entity
@Table(name = "sensors")
public class HumiditySensor extends NamedEntity{
	
	private static final long serialVersionUID = 1L;
	
    @Column(name = "humidity")
    private int humidity;
        
    @ManyToOne
    @JoinColumn(name = "id_plant")
    private Plant plant;
    
    public int getHumidity() {
		return humidity;
	}
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
}
