package com.controltower.model.airport;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.controltower.model.OperationPermission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAirport;
	private String name;
	@ManyToOne
	@JoinColumn(name = "idAddress")
	private Address address;
	@OneToMany(mappedBy = "airport")
	private List<OperationPermission> operationPermissions;
}
