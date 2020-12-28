package com.linking.db.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import com.linking.db.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, UUID> {
	@AllowFiltering
	List<Comment> findByPostId(final UUID postId);

	@AllowFiltering
	List<Comment> findByUserId(final UUID userId);

	void deleteByPostId(final UUID postId);

}
