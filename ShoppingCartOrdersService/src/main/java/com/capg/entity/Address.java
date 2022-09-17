package com.capg.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	

	private Integer houseNumber;

	private String streetName;
	

	private String colonyName;
	

	private String city;
	

	private String state;
	

	private int pincode;
	
	
	
}
