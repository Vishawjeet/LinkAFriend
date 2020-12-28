package com.linking.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linking.db.dao.CommentRepository;
import com.linking.db.dao.PostRepository;
import com.linking.db.entity.Comment;
import com.linking.db.entity.Post;
import com.linking.db.entity.PostPrimaryKey;

@Service
public class PostService implements BService<Post, UUID>{

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	public Post get(UUID postId) {
		Optional<Post> optPost = postRepository.findByPostId(postId);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			List<Comment> comments = getAllCommentByPostId(postId);
			post.setComments(comments);
			return post;
		}
		return null;
	}


	public List<Comment> getAllCommentByPostId(UUID postID) {
		return commentRepository.findByPostId(postID);
	}
	
	public List<Post> getByUserName(String userName) {
		List<Post> postList = postRepository.findByUserName(userName);
		for (Post post : postList) {
			List<Comment> comments = getAllCommentByPostId(post.getPostId());			
			post.setComments(comments);
		}		
		return postList;
	}
	
	public List<Post> getByUserId(UUID userId) {
		List<Post> postList = postRepository.findByUserId(userId);
		for (Post post : postList) {
			List<Comment> comments = getAllCommentByPostId(post.getPostId());			
			post.setComments(comments);
		}		
		return postList;
	}
	
	public Post update(Post newPost, UUID postId) {
		Optional<Post> optPost = postRepository.findByPostId(postId);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			post = updatePost(newPost, post);
			return post;
		}
		return null;
	}
	
	public Comment update(Comment newComment, UUID commentId) {
		Optional<Comment> optComment = commentRepository.findById(commentId);
		if(optComment.isPresent()) {
			Comment comment = optComment.get();
			newComment.setCommentContent(newComment.getCommentContent());
			return comment;
		}
		return null;
	}
	
	
	public Post likePost(UUID postId, UUID userId) {
		Optional<Post> optPost = postRepository.findByPostId(postId);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			Set<UUID> likedBy = post.getLikedBy();
			if(likedBy==null) {
				likedBy = new HashSet<>();
			}
			likedBy.add(userId);
			post.setLikedBy(likedBy);
			post = postRepository.save(post);
			return post;
		}
		return null;
	}	
	
	public Post unlikePost(UUID postId, UUID userId) {
		Optional<Post> optPost = postRepository.findByPostId(postId);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			Set<UUID> likedBy = post.getLikedBy();
			if(likedBy==null) {
				likedBy = new HashSet<>();
			}
			likedBy.remove(userId);
			post.setLikedBy(likedBy);
			post = postRepository.save(post);
			return post;
		}
		return null;
	}	
	
	public Comment addComment(Comment newComment) {
		UUID uuid = UUID.randomUUID();
		LocalDateTime localDateTime = LocalDateTime.now();
		Comment comment = new Comment(uuid, localDateTime, newComment.getCommentContent(), newComment.getPostId(),
				newComment.getUserId());
		return commentRepository.save(comment);
	}
	
	private Post updatePost(Post newPost, Post post) {
		post.setPostContent(newPost.getPostContent());
		post.setPostType(newPost.getPostType());
		post.setPostURL(newPost.getPostURL());
		post.setPostVisibilty(newPost.getPostVisibilty());
		return postRepository.save(post);
	}


	public boolean delete(UUID postId) {
		Optional<Post> optPost = postRepository.findByPostId(postId);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			commentRepository.deleteByPostId(post.getPostId());
			postRepository.delete(post);
			return true;
		}
		return false;
	}
	
	public boolean deleteComment(UUID commentId) {
		Boolean result = commentRepository.existsById(commentId);
		commentRepository.deleteById(commentId);		
		return result;
	}

	@Override
	public Post add(Post newPost) {
		UUID uuid = UUID.randomUUID();
		LocalDateTime localDateTime = LocalDateTime.now();
		Post post  = new Post(uuid, localDateTime,newPost.getPostType(), newPost.getPostContent(), newPost.getPostURL(), newPost.getPostVisibilty(),
				newPost.getUserName(), newPost.getUserId()); 
		post = postRepository.save(post);		
		return post;
	}

}
