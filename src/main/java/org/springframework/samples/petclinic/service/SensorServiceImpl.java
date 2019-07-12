package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.sensor.HumiditySensor;
import org.springframework.samples.petclinic.sensor.HumiditySensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorServiceImpl implements SensorService {

	private HumiditySensorRepository sensorRepository;

	@Autowired
	public SensorServiceImpl(HumiditySensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

//	@Override
//	public HumiditySensor findHumiditySensorById(int id) throws DataAccessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	@Transactional(readOnly = true)
//	public Collection<HumiditySensor> findAllHumiditySensor() throws DataAccessException {
//		return sensorRepository.findAll();
//	}

	@Override
	public void saveHumiditySensor(HumiditySensor sensor) throws DataAccessException {
		sensorRepository.save(sensor);		
	}

//	@Override
//	@Transactional(readOnly = true)
//	public void deleteHumiditySensor(HumiditySensor sensor) throws DataAccessException {
//		sensorRepository.delete(sensor);		
//	}

	
}
