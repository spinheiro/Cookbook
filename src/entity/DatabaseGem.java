package entity;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseGem {
	public static void main(String args[]){
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "create");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cookbook", properties);
		
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
	}
}
