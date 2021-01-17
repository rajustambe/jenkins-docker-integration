package com.example.testcontrollerexample;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {

	@GetMapping("/hello")
	public String getHello(){
		return "Hello Raju";
	}
	
	@PostMapping(value = "/helloWorld", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String getHelloWorld(@RequestBody MultiValueMap<String, String> map) {
		String clientId = map.getFirst("client_id");
		return "hello World your ClientId is " + clientId;
	}
}
