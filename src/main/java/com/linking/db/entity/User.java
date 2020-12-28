package com.linking.db.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import edu.umd.cs.findbugs.annotations.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(value = "link_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	 @PrimaryKey 
	 @Column(value = "user_id")
	 private @NonNull UUID userId;
	 @Column(value = "user_name")
	 private @NonNull String userName;
	 @Column(value = "first_name")
	 private @NonNull String firstName;
	 @Column(value = "last_name")
	 private @NonNull String lastName;
	 private @NonNull String email;
	 private @NonNull String password;
	 private @NonNull String gender;
	 @Column(value = "mobile_number")
	 private @NonNull String mobileNumber;	 
	 @Column(value = "date_of_birth")
	 private String dateOfBirth;	
	 @Column(value = "timestamp_join")
	 private Long joinDate; 	 
}
