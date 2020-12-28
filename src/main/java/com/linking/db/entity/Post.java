package com.linking.db.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import edu.umd.cs.findbugs.annotations.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(value = "user_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	public Post(UUID postId, LocalDateTime postDateTime, String postType, String postContent, String postURL, String postVisibilty,
			String userName,  UUID userId) {
		this.postId = postId;
		this.postDateTime = postDateTime;
		this.postContent = postContent;
		this.postType = postType;
		this.postURL = postURL;
		this.postVisibilty = postVisibilty;
		this.userName = userName;
		this.userId = userId;
	}

	@PrimaryKey
	private UUID postId;
	// @PrimaryKey private PostPrimaryKey key;
	@Column(value = "post_date_time")
	private LocalDateTime postDateTime;
	@Column(value = "user_name")
	private String userName;
	@Column(value = "user_id")
	private UUID userId;
	@Column(value = "post_type")
	private @NonNull String postType;
	@Column(value = "post_url")
	private @NonNull String postURL;
	@Column(value = "post_content")
	private @NonNull String postContent;
	@Column(value = "post_visibility")
	private @NonNull String postVisibilty;
	@Column
	Set<UUID> likedBy;
	@Transient
	private List<Comment> comments;
}
