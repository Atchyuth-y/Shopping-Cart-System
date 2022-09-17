package com.capg.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {


	private String fullName;

	private String emailId;

//	private String username;

	private String password;

	private long mobileNumber;

	private LocalDate dateOfBirth;

	private String gender;

	private List<Address> address;




}