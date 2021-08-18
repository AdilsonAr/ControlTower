package com.controltower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controltower.model.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {

}
