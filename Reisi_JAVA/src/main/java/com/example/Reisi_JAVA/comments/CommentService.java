package com.example.Reisi_JAVA.comments;


import org.springframework.stereotype.Service;


@Service
public class CommentService {
		  private CommentRepository commentRepository;

		  public CommentService(CommentRepository commentRepository) {
		    this.commentRepository = commentRepository;
		  }
		  
			Comment addCommentForPost(Comment comment) {
				return commentRepository.save(comment);
			}
}
