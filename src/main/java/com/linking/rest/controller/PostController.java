package com.linking.rest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linking.db.entity.Comment;
import com.linking.db.entity.Post;
import com.linking.db.entity.User;
import com.linking.exception.ResourceNotFoundException;
import com.linking.service.PostService;


@RestController
@RequestMapping("/post")
public class PostController  implements  Controller<Post, String>{

    @Autowired
    PostService postService;

    @GetMapping("/userName/{userName}")
    public List<Post> getAllPostByUserName(@PathVariable(value = "userName") String userName) {
        return postService.getByUserName(userName);
    }
    @GetMapping("/userId/{userId}")
    public List<Post> getAllPostByUserId(@PathVariable(value = "userId") String userId) {
        return postService.getByUserId(UUID.fromString(userId));
    }

    @PostMapping("/")
    public Post add(@RequestBody Post newPost) {
        return postService.add(newPost);
    }    

    @GetMapping("/{postId}")
    public Post get(@PathVariable(value = "postId") String postId) {
    	Post post = postService.get(UUID.fromString(postId));
    	if(post==null) 
    	{
    		throw new ResourceNotFoundException("Post", "id", postId);
    	}
        return post;
    }
    

    @PutMapping("/{postId}")
    public Post update(@RequestBody Post newPost, @PathVariable(value = "postId") String postId) {
    	Post post = postService.update(newPost, UUID.fromString(postId));
    	if(post==null) 
    	{
    		throw new ResourceNotFoundException("Post", "id", postId);
    	}
        return post;
    }
    
    @PutMapping("/like/{postId}")
    public Post like(@RequestBody User user, @PathVariable(value = "postId") String postId) {
    	Post post = postService.likePost(UUID.fromString(postId), user.getUserId());
    	if(post==null) 
    	{
    		throw new ResourceNotFoundException("Post", "id", postId);
    	}
        return post;
    }
    
    @PutMapping("/unlike/{postId}")
    public Post unlike(@RequestBody User user, @PathVariable(value = "postId") String postId) {
    	Post post = postService.unlikePost(UUID.fromString(postId), user.getUserId());
    	if(post==null) 
    	{
    		throw new ResourceNotFoundException("Post", "id", postId);
    	}
        return post;
    }
    
    @DeleteMapping( value ="/{postId}", produces = "application/json; charset=utf-8")
	public String delete(@PathVariable(value = "postId") String postId) {
		boolean result = postService.delete(UUID.fromString(postId));
		return "{ \"success\" : " + (result ? "true" : "false") + " }";	
	}
    
    @GetMapping("/comments/{postId}")
    public List<Comment> getComment(@PathVariable(value = "postId") String postId) {
    	List<Comment> comments = postService.getAllCommentByPostId(UUID.fromString(postId));
    	return comments;
    }
    
    @PostMapping("/comment/")
    public Comment add(@RequestBody Comment newComment) {
    	return postService.addComment(newComment);
    }
    
    @PutMapping("/comment/{commentId}")
    public Comment update(@RequestBody Comment newComment, @PathVariable(value = "commentId") String commentId) {
    	Comment post = postService.update(newComment, UUID.fromString(commentId));
    	if(post==null) 
    	{
    		throw new ResourceNotFoundException("Comment", "id", commentId);
    	}
        return post;
    }
    @DeleteMapping( value ="/comment/{commentId}", produces = "application/json; charset=utf-8")
	public String deleteComment(@PathVariable(value = "commentId") String commentId) {
		boolean result = postService.deleteComment(UUID.fromString(commentId));
		return "{ \"success\" : " + (result ? "true" : "false") + " }";	
	}
}