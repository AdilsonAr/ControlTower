package com.controltower;

import java.util.List;

import com.controltower.model.Aircraft;
import com.controltower.service.AircraftService;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		AircraftService service= new AircraftService();
		List<Aircraft> list=service.getAllowed();
		list.forEach(x->{
			System.out.println(x.getModel());
		});
	}

}
