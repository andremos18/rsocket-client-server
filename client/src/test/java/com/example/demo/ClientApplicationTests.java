package com.example.demo;

import com.example.rsocket.publisher.configuration.RSocketConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RSocketConfig.class})
class ClientApplicationTests {

	@Test
	void contextLoads() {
	}

}
