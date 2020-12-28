package com.linking.db.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import com.linking.db.entity.Post;
import com.linking.db.entity.PostPrimaryKey;

public interface PostRepository extends CrudRepository<Post, PostPrimaryKey> {
	Optional<Post> findByPostId(final UUID postId);

	@AllowFiltering
	List<Post> findByUserName(final String userName);

	@AllowFiltering
	List<Post> findByUserId(final UUID userId);
}
