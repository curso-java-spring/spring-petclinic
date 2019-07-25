package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.plant.Plant;
import org.springframework.samples.petclinic.sensor.HumiditySensor;

public interface SensorService {

	Plant findPlantById(int plantId) throws DataAccessException;
	void savePlant(Plant plant) throws DataAccessException;
	
	HumiditySensor findHumiditySensorById(int sensorId) throws DataAccessException;
	Collection<HumiditySensor> findAllHumiditySensor() throws DataAccessException;
	void saveHumiditySensor(HumiditySensor sensor) throws DataAccessException;
	void deleteHumiditySensor(HumiditySensor sensor) throws DataAccessException;	
	
	
}
