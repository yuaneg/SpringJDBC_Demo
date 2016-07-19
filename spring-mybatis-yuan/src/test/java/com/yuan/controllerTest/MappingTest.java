package com.yuan.controllerTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import com.yuan.BaseTest;

public class MappingTest extends BaseTest {

	@Test
	public void testByPath() throws Exception {
		super.getMockMvc().perform(get("/mapping/path")).andExpect(status().isOk());
	}

	@Test
	public void testByPathPattern() throws Exception {
		super.getMockMvc().perform(get("/mapping/path/anything")).andExpect(status().isOk());
	}

	@Test
	public void testByParameter() throws Exception {
		super.getMockMvc().perform(get("/mapping/parameter")).andExpect(status().isOk());
	}

	@Test
	public void testByParameterNegation() throws Exception {
		super.getMockMvc().perform(get("/mapping/parameter?foo=apple")).andExpect(status().isOk());
	}


	@Test
	public void testByProducesXml() throws Exception {
		MvcResult m = super.getMockMvc().perform(get("/mapping/produces.xml")).andExpect(status().isOk()).andReturn();
		System.out.println(m.getResponse().getContentAsString());
	}
}
