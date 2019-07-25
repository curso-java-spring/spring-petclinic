package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.plant.Plant;
import org.springframework.samples.petclinic.plant.PlantRepository;
import org.springframework.samples.petclinic.sensor.HumiditySensor;
import org.springframework.samples.petclinic.sensor.HumiditySensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorServiceImpl implements SensorService {

	private HumiditySensorRepository sensorRepository;
	private PlantRepository plantRepository;

	@Autowired
	public SensorServiceImpl(HumiditySensorRepository sensorRepository,PlantRepository plantRepository) {
		this.sensorRepository = sensorRepository;
		this.plantRepository = plantRepository;
	}

	@Override
	public HumiditySensor findHumiditySensorById(int sensorId) throws DataAccessException {
		HumiditySensor sensor = null;
		try {
			sensor = sensorRepository.findById(sensorId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return sensor;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<HumiditySensor> findAllHumiditySensor() throws DataAccessException {
		return sensorRepository.findAll();
	}

	@Override
	public void saveHumiditySensor(HumiditySensor sensor) throws DataAccessException {
		sensorRepository.save(sensor);		
	}

	@Override
	@Transactional(readOnly = true)
	public void deleteHumiditySensor(HumiditySensor sensor) throws DataAccessException {
		sensorRepository.delete(sensor);		
	}

	@Override
	public Plant findPlantById(int plantId) throws DataAccessException {
		Plant plant = null;
		try {
			plant = plantRepository.findById(plantId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return plant;
	}

	@Override
	
	public void savePlant(Plant plant) throws DataAccessException {
		plantRepository.save(plant);
		
	}

	
}
