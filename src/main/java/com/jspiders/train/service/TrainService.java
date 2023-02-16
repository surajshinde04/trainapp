package com.jspiders.train.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.train.pojo.TrainPOJO;
import com.jspiders.train.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	private TrainRepository repository;
	
	public TrainPOJO add(int train_number, String train_name, String from, String to, double total_kms, String depart_time,
			String arrival_time, String total_travelling_hours, String username, String password) {
		TrainPOJO train = repository.add(train_number,train_name,from,to,total_kms,depart_time,arrival_time,total_travelling_hours,username,password);
		return train;
		}

	public TrainPOJO search(int train_number) {
		TrainPOJO train = repository.search(train_number);
		return train;
	}


	public List<TrainPOJO> searchAll() {
		List<TrainPOJO> trains = repository.searchAll();
		return trains;
	}

	public TrainPOJO remove(int train_number) {
		TrainPOJO train = repository.remove(train_number);
		return train;
	}

	public TrainPOJO update(int train_number, String train_name, String from, String to, double total_kms, String depart_time,
			String arrival_time, String total_travelling_hours) {
		TrainPOJO train = repository.update(train_number,train_name,from,to,total_kms,depart_time,arrival_time,total_travelling_hours);
		return train;
	}

	
	public TrainPOJO login(String username, String password) {
		TrainPOJO train = repository.login(username, password);
		return train;
	}


//	public TrainPOJO search(int train_number) {
//		TrainPOJO train = repository.search(train_number);
//		return train;
	//}
}
