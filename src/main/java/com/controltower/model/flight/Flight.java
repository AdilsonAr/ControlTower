package com.controltower.model.flight;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.controltower.model.Aircraft;
import com.controltower.model.Airline;
import com.controltower.model.airport.Airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFlight;
	private String flightNumber;
	@ManyToOne
	@JoinColumn(name = "idOriginAirport")
	private Airport originAirport;
	@ManyToOne
	@JoinColumn(name = "idDestinationAirport")
	private Airport destinationAirport;
	private LocalDateTime dateTimeDeparture;
	private LocalDateTime dateTimeArrival;
	private LocalDateTime expectedDateTimeArrival;
	@ManyToOne
	@JoinColumn(name = "idAircraft")
	private Aircraft aircraft;
	@ManyToOne
	@JoinColumn(name = "idAirline")
	private Airline airline;
	@OneToMany(mappedBy = "flight")
	private List<FlightIncident> listFlightIncidents;
	@Transient
	private FlightState currentState;
	private String currentStateText;

}
