package com.controltower.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aircraft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAircraft;
	private String model;
	private int passengerCapacity;
	private double rangeFuelTank;
	private boolean isAvailable;
	@OneToMany(mappedBy = "aircraft")
	private List<OperationPermission> operationPermissions;
}
