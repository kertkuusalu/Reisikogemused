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

import com.example.Reisi_JAVA.post.Post;
import com.example.Reisi_JAVA.post.PostRepository;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ReisiJavaApplicationTests {

	private Post post;
	private List<Post> postList;
	private String testImgPath = "https://secure.cdn1.wdpromedia.com/resize/mwImage/1/640/360/75/dam/wdpro-assets/dlr/gallery/destinations/disneyland-park/disneyland-gallery00.jpg?1504908934350";
	@Before
    public void setUp(){
        post = new Post("Disney land", "USA", "Washington", "content", testImgPath);
        entityManager.merge(post);
        entityManager.flush();
        entityManager.clear();
        postList = postRepository.findAll();
	}
	@After
    public void tearDown(){
        post = null;
	}
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private PostRepository postRepository;
	
	@Test
	public void FindAllReturnsSomething() {
		
		assertNotNull(postRepository.findAll());
	}
	@Test
	public void addHeaderTest() {
		int length = postList.size();
		String header = postList.get(length -1).header;
		assertEquals(header,post.header);

	}
	@Test
	public void addCountryTest() {
		int length = postList.size();
		String country = postList.get(length -1).country;
		assertEquals(country,post.country);

	}
	@Test
	public void addCityTest() {
		int length = postList.size();
		String city = postList.get(length -1).city;
		assertEquals(city,post.city);

	}
	@Test
	public void addImagePathTest() {
		int length = postList.size();
		String imagePath = postList.get(length -1).imagePath;
		assertEquals(imagePath,post.imagePath);

	}
}
