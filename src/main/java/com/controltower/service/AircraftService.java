package com.controltower.service;

import java.util.List;

import com.controltower.dao.AircraftDao;
import com.controltower.model.Aircraft;

public class AircraftService {
	private AircraftDao aircraftDao;
	public AircraftService() {
		super();
		aircraftDao=new AircraftDao();
	}

	public List<Aircraft> getAllowed(){
		return aircraftDao.getAllowed();
	}
}
