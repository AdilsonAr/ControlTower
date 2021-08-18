package com.controltower.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.controltower.model.airport.Airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OperationPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperationPermission;
	@ManyToOne
	@JoinColumn(name="idAirport")
	private Airport airport;
	@ManyToOne
	@JoinColumn(name="idAircraft")
	private Aircraft aircraft;
}
