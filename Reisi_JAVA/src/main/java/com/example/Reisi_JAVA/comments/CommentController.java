package com.example.Reisi_JAVA.comments;

import java.awt.print.Pageable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reisi_JAVA.post.Post;
import com.example.Reisi_JAVA.post.PostRepository;
import com.example.Reisi_JAVA.post.PostService;

@RestController
public class CommentController {
	private CommentService commentService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;

	  public CommentController(CommentService commentService) {
	    this.commentService = commentService;
	  }


	  @RequestMapping(value="/posts/{postId}/comments", method = RequestMethod.GET)
	  	public List<Comment> getCommentsByPostId(@PathVariable(value="postId") Long postId) {
		  return commentRepository.findByPostId(postId);
	  }
	  
	  @RequestMapping(value="/posts/{postId}/comments",method = RequestMethod.POST, consumes = "application/json")
	  	public Comment addComment(@PathVariable (value = "postId") Long postId,
	  			@RequestBody Comment comment) {
		  				return postRepository.findById(postId).map(post -> {
		  				comment.setPost(post);
		  				return commentRepository.save(comment);
		  				}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + "not found"));
		  
	  }
}
		
