package com.controltower.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.controltower.configuration.EntityManagerProvider;
import com.controltower.model.Aircraft;

public class AircraftDao {
	public List<Aircraft> getAllowed(){
		EntityManagerFactory emf = EntityManagerProvider.get();
        EntityManager entityManager = emf.createEntityManager();
        
        TypedQuery<Aircraft> q = entityManager.createQuery("select x from Airport a JOIN OperationPermission o Join Aircraft x  WHERE a.idAirport = 1", Aircraft.class);
        List<Aircraft> resultList = q.getResultList();
        entityManager.close();
        return resultList;
	}
}
