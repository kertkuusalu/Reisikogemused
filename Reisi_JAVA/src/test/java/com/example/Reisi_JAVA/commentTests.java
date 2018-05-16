package com.example.Reisi_JAVA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Reisi_JAVA.comments.Comment;
import com.example.Reisi_JAVA.comments.CommentRepository;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class commentTests {

	private Comment comment;
	private List<Comment> commentList;
	
	@Before
    public void setUp(){
        comment = new Comment("Kommentaar", "Oi kui vahva");
        entityManager.merge(comment);
        entityManager.flush();
        commentList = commentRepository.findAll();
	}
	@After
    public void tearDown(){
        comment = null;
	}
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CommentRepository commentRepository;
	
	@Test
	public void FindAllReturnsSomething() {
		
		assertNotNull(commentRepository.findAll());
	}
	@Test
	public void TitleTest() {
		int length = commentList.size();
		String title = commentList.get(length -1).title;
		assertEquals(title,comment.title);

	}
	@Test
	public void ContentTest() {
		int length = commentList.size();
		String content = commentList.get(length -1).comment;
		assertEquals(content,comment.comment);

	}
}
