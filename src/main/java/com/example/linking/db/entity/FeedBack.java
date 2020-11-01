package com.example.linking.db.entity;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import edu.umd.cs.findbugs.annotations.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(value = "link_user")
@Getter
@Setter
@NoArgsConstructor
public class FeedBack 
{
	 @PrimaryKey 
	 @Column(value = "feedback_id")
	 private @NonNull String feedBackId;
	 @Column(value = "user_id")
	 private @NonNull String userId;
	 @Column(value = "feedback_txt")
	 private @NonNull String feedBack;
	 @Column(value = "feedback_date")
	 private @NonNull Date feedbackDate;		

}
