package com.example.testcontrollerexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestControllerExampleApplicationTests {

	private MockMvc mockMvc;

	@InjectMocks
	private HelloResource hello;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(hello).build();
	}
	
	@Test
	public void helloTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello Raju"));

	}
	
	@Test
	public void helloWorldTest() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	       map.add("client_id", "12345");
	       map.add("client_secret", "secret");
	       map.add("code", "code");
	       map.add("grant_type", "authorization_code");
		mockMvc.perform(MockMvcRequestBuilders.post("/api//helloWorld").params(map).contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello World your ClientId is 12345"));
		
	}
}
