package com.example.Reisi_JAVA.post;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.Reisi_JAVA.comments.Comment;

import lombok.Getter;
import lombok.Setter;

@Entity

public class Post {
	@Id
	@GeneratedValue
	long id;
	String header;
	String country;
	String city;
	String content;
	String imagePath;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="post")
	List<Comment> comments;
	
	public void setId (Long i) {
	    id = i ;
	} 
	
	public void setHeader (String h) {
		    header = h ;
		} 
	public void setcountry (String c) {
	    country = c ;
	} 
	public void setcity (String ct) {
	    city = ct ;
	} 
	public void setContent (String cn) {
	    content = cn ;
	} 
	/*public void setComments (List<Comment> cm) {
	    comments = cm ;
	} */
	public void setimagePath (String img ) {
	    imagePath = img ;
	} 
	public Long getId() {
		   return id;
		} 
	public String getHeader() {
		   return header;
		} 

	public String getCountry() {
		   return country;
		} 
	public String getCity() {
		   return city;
		} 
	public String getContent() {
		   return content;
		} 
	public String getImagePath() {
		   return imagePath;
		} 
}
