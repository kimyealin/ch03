package yeling.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import yeling.spring.domain.BoardVO;
import yeling.spring.service.BoardService;


//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc //컨트롤러 뿐아니라 @Repository, @Service까지 메모리에 다 올림
//@WebMvcTest
public class BoardControllerTest {
	@Autowired
//	private TestRestTemplate restTemplate;
	private MockMvc mockMvc;
	@MockBean
	private BoardService boardService;
	@Test
	public void testHello() throws Exception{
		when(boardService.hello("사오정")).thenReturn("Hello : 사오정");
		mockMvc.perform(get("/hello").param("name","사오정"))
		.andExpect(status().isOk()).andExpect(content().string("Hello : 사오정")).andDo(print());
//		 .andExpect(view().name("hello"))
//		 .andExpect(redirectUrl("/index"))
		
//	@Test
//	public void testGetBoard() throws Exception{
//		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
//		assertEquals("손오공", board.getWriter());
//	}
	}
}
