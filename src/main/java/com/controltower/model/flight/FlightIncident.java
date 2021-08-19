package com.controltower.model.flight;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlightIncident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFlightIncident;
	@ManyToOne
	@JoinColumn(name = "idFlight")
	private Flight flight;
	@Transient
	private FlightState flightState;
	private String flightStateText;
	private String title;
	private String description;
	private LocalDateTime timeStamp;

}
