package com.controltower.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.controltower.model.flight.Flight;

public class FlightDao { 
	public List<Flight> readAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controltower_unit");
        EntityManager entityManager = emf.createEntityManager();
        
        Query q = entityManager.createQuery("select s from Flight s");
        List<Flight> resultList = q.getResultList();
        entityManager.close();
        return resultList;
	}
	
	public Flight readById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controltower_unit");
        EntityManager entityManager = emf.createEntityManager();
        
        Flight flight = entityManager.find(Flight.class, id);
        entityManager.close();
        return flight;
	}
}
