package com.example.Reisi_JAVA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReisiJavaApplicationTests {

	@Test
	public void contextLoads() {
	}

	
	@Test
	public void FindAllReturnsSomething() {
		var postRepository = new PostRepository();
		
		assertNotNull(postRepository.findAll());
	}
}
