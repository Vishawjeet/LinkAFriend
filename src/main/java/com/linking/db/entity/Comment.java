package com.linking.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import edu.umd.cs.findbugs.annotations.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(value = "post_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	@PrimaryKey
	@Column(value = "comment_id")
	private UUID commentId;
	@Column(value = "comment_date_time")
	private LocalDateTime commentDateTime;
	@Column(value = "comment_content")
	private @NonNull String commentContent;
	@Column(value = "post_id")
	private UUID postId;
	@Column(value = "user_id")
	private UUID userId;
}
