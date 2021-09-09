package com.controltower.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.controltower.configuration.EntityManagerProvider;
import com.controltower.model.flight.Flight;

public class FlightDao {
	public List<Flight> readAll() {
		EntityManagerFactory emf = EntityManagerProvider.get();
		EntityManager entityManager = emf.createEntityManager();

		Query q = entityManager.createQuery("select s from Flight s");
		List<Flight> resultList = q.getResultList();
		entityManager.close();
		return resultList;
	}

	public List<Flight> readByDay(LocalDate date) {
		EntityManagerFactory emf = EntityManagerProvider.get();
		EntityManager entityManager = emf.createEntityManager();

		DateTimeFormatter formatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateParameter = date.format(formatterDateOnly);
		TypedQuery<Flight> q = entityManager.createQuery("select u from Flight u WHERE DATE(u.dateTimeDeparture) = '"
				+ dateParameter + "' or DATE(u.dateTimeArrival) = '" + dateParameter + "'", Flight.class);
		List<Flight> resultList = q.getResultList();
		System.out.println(resultList.getClass().getCanonicalName());
		entityManager.close();
		return resultList;
	}

	public void update(Flight flight) {
		EntityManagerFactory emf = EntityManagerProvider.get();
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(flight);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void create(Flight flight) {
		EntityManagerFactory emf = EntityManagerProvider.get();
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(flight);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public Flight readById(int id) {
		EntityManagerFactory emf = EntityManagerProvider.get();
		EntityManager entityManager = emf.createEntityManager();

		Flight flight = entityManager.find(Flight.class, id);
		entityManager.close();
		return flight;
	}

	public Flight readByNumber(String number) {
		EntityManagerFactory emf = EntityManagerProvider.get();
		EntityManager entityManager = emf.createEntityManager();

		Query q = entityManager.createQuery("select s from Flight s where s.flightNumber = '" + number + "'",
				Flight.class);
		Flight result = (Flight) q.getResultList().get(0);
		entityManager.close();
		return result;
	}

}
