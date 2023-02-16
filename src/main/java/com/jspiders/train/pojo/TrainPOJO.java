package com.jspiders.train.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TrainPOJO {


	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Id
	private int train_number;
	
	private String train_name;

	private String from_station;

	private String to_station;

	private double total_kms;

	private String depart_time;

	private String arrival_time;

	private String total_travelling_hours;

	private String username;

	private String password;

}
