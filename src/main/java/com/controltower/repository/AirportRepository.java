package com.controltower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controltower.model.airport.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

}
