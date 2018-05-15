package com.example.Reisi_JAVA.comments;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	/*@Override
	public List<Comment> findAll();
	*/
	List<Comment> findByPostId(Long postId);
}
