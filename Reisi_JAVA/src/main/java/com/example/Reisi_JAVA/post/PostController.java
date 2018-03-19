package com.example.Reisi_JAVA.post;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping(value="/NewPost/add", method=RequestMethod.POST,
			consumes = "application/json")
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}
}
