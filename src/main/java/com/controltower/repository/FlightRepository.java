package com.controltower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controltower.model.flight.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
