package com.jq.filemngr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class FileMngrRestController {

	@Autowired
	FileMngrService fileMngrService;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String upload(@RequestParam("file") MultipartFile file) {

		String fileName = String.format("%s", file.getOriginalFilename());

		try {
			fileMngrService.upload(fileName, file.getInputStream());
			return "upload file";
		} catch (Exception e) {
			e.printStackTrace();
			return "An error has ocurred";
		}
	}

	@GetMapping("/read/{filename}")
	public ResponseEntity<String> getContent(@PathVariable(value = "filename") String fileName) {
		try {
			return new ResponseEntity<>(fileMngrService.getContent(fileName), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error readign file", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}