package com.maintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {

	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	
	public static void setUpBeforeClass() {
		entityManagerFactory=Persistence.createEntityManagerFactory("Home Maintenance System");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	public static void tearDownAfterClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
