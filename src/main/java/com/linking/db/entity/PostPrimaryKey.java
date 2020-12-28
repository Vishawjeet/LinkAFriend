package com.linking.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@PrimaryKeyClass
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class PostPrimaryKey {
//	@PrimaryKeyColumn(name = "post_id", ordinal = 1, ordering = Ordering.DESCENDING)
//	private UUID postId;
	@PrimaryKeyColumn(name = "post_date_time", ordinal = 0)
	private LocalDateTime postDateTime;
	@PrimaryKeyColumn(name = "user_name", type = PrimaryKeyType.PARTITIONED)
	private String userName;
	@PrimaryKeyColumn(value = "user_id",  ordinal = 2, ordering = Ordering.DESCENDING)
	private  UUID userId;

}
