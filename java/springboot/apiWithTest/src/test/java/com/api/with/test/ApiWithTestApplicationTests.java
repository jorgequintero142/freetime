package com.api.with.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiWithTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGet() throws Exception {
		ResultActions resultActions = mockMvc.perform(get(("/hi"))).andExpect(status().isOk()).andDo(print());
		assertEquals("Hi, this is GET", this.extractResult(resultActions));
	}

	@Test
	void testPost() throws Exception {
		ResultActions resultActions = mockMvc.perform(post("/hi")).andExpect(status().isOk()).andDo(print());
		assertEquals("Hi, this is POST", this.extractResult(resultActions));
	}

	@Test
	void testNotFound() throws Exception {
		mockMvc.perform(get("/notFound")).andExpect(status().isNotFound());
	}

	@Test
	void testHello() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/hello")).andExpect(status().isOk()).andDo(print());
		assertEquals("Hello jorge", this.extractResult(resultActions));
		
		resultActions = mockMvc.perform(get("/hello?nameFriend=luu")).andExpect(status().isOk()).andDo(print());
		assertEquals("Hello luu", this.extractResult(resultActions));
	}

	private String extractResult(ResultActions resultActions) throws Exception {
		return resultActions.andReturn().getResponse().getContentAsString();
	}
}
