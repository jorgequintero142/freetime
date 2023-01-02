package jq.demojwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/v1/hello")
	public String hello() {
		return "Hello jwt";
	}

	@GetMapping("/api/v1/user")
	public String user() {
		return "Hello user!";
	}

	@GetMapping("/api/v1/admin")
	public String admin() {
		return "Hello admin!";
	}
}