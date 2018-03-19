package com.example.Reisi_JAVA.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	@Override
	public List<Post> findAll();
}
