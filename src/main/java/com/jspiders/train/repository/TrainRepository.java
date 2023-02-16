package com.jspiders.train.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.train.pojo.TrainPOJO;

@Repository

public class TrainRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("PROJECT");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
		
	}
	public TrainPOJO add(int train_number, String train_name, String from, String to, double total_kms, String depart_time,
			String arrival_time, String total_travelling_hours, String username, String password) {
		openConnection();
		transaction.begin();
		TrainPOJO pojo = new TrainPOJO();
		pojo.setTrain_number(train_number);
		pojo.setTrain_name(train_name);
		pojo.setFrom_station(from);
		pojo.setTo_station(to);
		pojo.setTotal_kms(total_kms);
		pojo.setDepart_time(depart_time);
		pojo.setArrival_time(arrival_time);
		pojo.setTotal_travelling_hours(total_travelling_hours);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;	
		}

	public TrainPOJO search(int train_number) {
		openConnection();
		transaction.begin();
		TrainPOJO train = manager.find(TrainPOJO.class, train_number);
		if (train != null) {
			transaction.commit();
			closeConnection();
			return train;
		}
		transaction.commit();
		closeConnection();
		return null;	
		}


	
	public TrainPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from TrainPOJO " + "where username = '" + username + "' " + "and password = '" + password + "'";
		query = manager.createQuery(jpql);
		List<TrainPOJO> resultList = query.getResultList();
		for (TrainPOJO train : resultList) {
			transaction.commit();
			closeConnection();
			return train;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	
	public List<TrainPOJO> searchAll() {
		openConnection();
		transaction.begin();
		jpql = "from TrainPOJO";
		query = manager.createQuery(jpql);
		List<TrainPOJO> trains = query.getResultList();
		transaction.commit();
		closeConnection();
		return trains;
	}

	public TrainPOJO remove(int train_number) {
		openConnection();
		transaction.begin();
		TrainPOJO train = manager.find(TrainPOJO.class, train_number);
		if (train != null) {
			manager.remove(train);
		}
		transaction.commit();
		closeConnection();
		return train;
	}

	public TrainPOJO update(int train_number, String train_name, String from, String to, double total_kms, String depart_time,
			String arrival_time, String total_travelling_hours) {
		openConnection();
		transaction.begin();
		TrainPOJO train = manager.find(TrainPOJO.class, train_number);
		if (train != null) {
			train.setTrain_number(train_number);
			train.setTrain_name(train_name);
			train.setFrom_station(from);
			train.setTo_station(to);
			train.setTotal_kms(total_kms);
			train.setDepart_time(depart_time);
			train.setArrival_time(arrival_time);
			train.setTotal_travelling_hours(total_travelling_hours);
			manager.persist(train);
			transaction.commit();
			closeConnection();
			return train;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

}
