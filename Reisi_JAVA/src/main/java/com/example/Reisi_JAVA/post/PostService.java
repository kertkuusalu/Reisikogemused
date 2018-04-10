package com.example.Reisi_JAVA.post;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostService {
	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	Post addPost(Post post) {
		return postRepository.save(post);
	}
	List<Post> getAllPosts() {
		return postRepository.findAll();
	}
}
