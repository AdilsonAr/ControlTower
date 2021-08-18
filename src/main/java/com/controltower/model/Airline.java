package com.controltower.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.controltower.model.flight.Flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAirline;
	private String name;
	@OneToMany(mappedBy = "airline")
	private List<Flight> listFlights;
}
