package com.controltower.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.controltower.configuration.EntityManagerProvider;
import com.controltower.model.flight.FlightIncident;

public class FlightIncidentDao {
	
	public void create(FlightIncident flightIncident) {
		EntityManagerFactory emf = EntityManagerProvider.get();
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(flightIncident);
        entityManager.getTransaction().commit();
        entityManager.close();
	}
}
