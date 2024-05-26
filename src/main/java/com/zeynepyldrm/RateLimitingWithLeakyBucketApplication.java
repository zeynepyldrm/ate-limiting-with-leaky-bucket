package com.zeynepyldrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimitingWithLeakyBucketApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimitingWithLeakyBucketApplication.class, args);
	}

}
