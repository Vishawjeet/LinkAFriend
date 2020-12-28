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

@Table(value = "link_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
	 @PrimaryKey 
	 @Column(value = "user_id")
	 private @NonNull UUID userId;
	 @Column(value = "profession")
	 private @NonNull String profession;
	 @Column(value = "relationship_status")
	 private @NonNull String relationshipStatus;
	 private @NonNull String hometown;
	 private String profileImagePath;
	 private String coverImagePath;
	 private String education;
}
