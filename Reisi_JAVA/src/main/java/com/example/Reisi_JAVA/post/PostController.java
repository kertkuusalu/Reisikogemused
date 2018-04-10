package com.example.Reisi_JAVA.post;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping(value="/NewPost/add",method=RequestMethod.POST, consumes = "application/json")
	public Post addPost(@RequestBody Post post){

            return postService.addPost(post);
	}
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}
	/*
	File upload
	@RequestMapping(value="/NewPost/add", method= RequestMethod.POST)
    public String addPost(
            @RequestParam("file") MultipartFile file){
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
        
    }
	*/
	
}
