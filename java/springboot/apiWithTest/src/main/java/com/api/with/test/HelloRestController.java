package com.api.with.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple RestControlller used by Testing get and post methods
 * 
 * @author jorgequintero
 *
 */
@RestController
@RequestMapping(value = "/")
public class HelloRestController {

	@GetMapping(value = "hi")
	public String hiOne() {
		return "Hi, this is GET";
	}

	@PostMapping(value = "hi")
	public String hiTwo() {
		return "Hi, this is POST";
	}

	@GetMapping(value = "hello")
	public String hiFriend(@RequestParam(name = "nameFriend", defaultValue = "jorge") String nameFriend) {
		return "Hello " + nameFriend;
	}
}
