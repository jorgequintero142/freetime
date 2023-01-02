package jq.demojwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/v1/hello")
	public String hello() {
		return "Hello jwt";
	}
	
	@GetMapping("/api/v1/hola")
	public String hello2() {
		return "Hello jwt2";
	}
}
