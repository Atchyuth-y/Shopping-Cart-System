package com.capg.CartService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Profiless")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "profile_sequence";

    @Id
    private int profileId;
    private String fullName;
    private String emailId;
    private Long mobileNumber;
    private LocalDate dateOfBirth;
    private String gender;

}
