package com.yuan.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import com.yuan.BaseTest;

public class SimpleTest extends BaseTest {

	@Test
	public void testLogin() throws Exception {
		this.getMockMvc().perform(post("/simple")).andExpect(status().isOk());
	}

}
