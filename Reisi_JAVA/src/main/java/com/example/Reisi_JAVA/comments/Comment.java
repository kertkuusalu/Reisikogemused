package com.example.Reisi_JAVA.comments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.Reisi_JAVA.post.Post;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
	@Id
	@GeneratedValue
	long id;
	public String title;
	public String comment;
	@ManyToOne
	Post post;
	
	
	public Comment(String title, String comment) {
		this.title = title;
		this.comment = comment;
	}
	
	public Comment(){
		
	}
	
}
