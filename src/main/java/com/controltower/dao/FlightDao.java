package com.controltower.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	public List<Flight> readByDay(LocalDate date){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controltower_unit");
        EntityManager entityManager = emf.createEntityManager();
        
        DateTimeFormatter formatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateParameter=date.format(formatterDateOnly);
        TypedQuery<Flight> q = entityManager.createQuery(
        		"select u from Flight u WHERE DATE(u.dateTimeDeparture) = '"
        		+ dateParameter
        		+ "' or DATE(u.dateTimeArrival) = '"
                		+ dateParameter
                		+ "'"
                		, Flight.class);
        List<Flight> resultList = q.getResultList();
        System.out.println(resultList.getClass().getCanonicalName());
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