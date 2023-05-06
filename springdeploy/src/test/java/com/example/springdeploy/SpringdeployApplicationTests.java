package com.example.springdeploy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringdeployApplicationTests {

	@Test
	void contextLoads() {
			System.getenv().forEach(
					(key, value)->System.out.println(key + " " + value)
			);
	}

}
