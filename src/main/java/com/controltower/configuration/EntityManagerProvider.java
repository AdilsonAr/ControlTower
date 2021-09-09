package com.controltower.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	private static EntityManagerFactory entityManagerFactory=null;

	private static void init(){
		entityManagerFactory=Persistence.createEntityManagerFactory("controltower_unit");
	}
	
	public static EntityManagerFactory get() {
		if(entityManagerFactory == null) {
			init();
		}
		return entityManagerFactory;
	}
	
}
