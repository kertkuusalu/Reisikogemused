package com.example.Reisi_JAVA.comments;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Reisi_JAVA.post.Post;

@Service
public class CommentService {
		  private CommentRepository commentRepository;

		  public CommentService(CommentRepository commentRepository) {
		    this.commentRepository = commentRepository;
		  }
		  

			Comment addCommentForPost(Comment comment) {
				return commentRepository.save(comment);
			}

		  /*public List<Comment> GetCommentsForPost(long post){
		    List<Comment> postComments = commentRepository.findAll()
		      .parallelStream()
		      .filter(c -> c.getPost() != null)
		      .filter(c -> c.getPost().getId() == post)
		      .collect(Collectors.toList());
		    return postComments;
		  }*/
}
