package com.blog.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class BlogApplication {

	@RequestMapping
	String home() {
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
