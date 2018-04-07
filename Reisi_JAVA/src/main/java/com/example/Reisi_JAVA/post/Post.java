package com.example.Reisi_JAVA.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue
	long id;
	String header;
	String country;
	String city;
	String content;
	String imagePath;
	
}
