package com.controltower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controltower.model.flight.FlightIncident;

@Repository
public interface FlightIncidentRepository extends JpaRepository<FlightIncident, Integer> {

}
