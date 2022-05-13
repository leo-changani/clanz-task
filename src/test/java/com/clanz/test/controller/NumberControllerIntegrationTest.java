package com.clanz.test.controller;

import com.clanz.test.config.AppConfig;
import com.clanz.test.domain.dto.GenerateNumberRequest;
import com.clanz.test.domain.dto.GenerateNumberResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@Import(AppConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@ExtendWith({ SpringExtension.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NumberControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	void generateNewNumbersWithValidCountShouldReturnOK() {
		GenerateNumberRequest request = new GenerateNumberRequest();
		request.setCount("5");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity<>(request, headers);
		String uri = "http://localhost:" + port + "/admin/generate";
		ResponseEntity<GenerateNumberResponse> response = restTemplate.exchange(uri, HttpMethod.POST, entity,
				GenerateNumberResponse.class);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
		Assertions.assertThat(response.getBody()).isNotNull();
		Assertions.assertThat(response.getBody().getNumbers().size()).isEqualTo(5);

	}

	@Test
	@Order(2)
	void generateNewNumbersWithNegativeCountShouldReturnBadRequest() {
		GenerateNumberRequest request = new GenerateNumberRequest();
		request.setCount("-2");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity<>(request, headers);
		String uri = "http://localhost:" + port + "/admin/generate";
		ResponseEntity<GenerateNumberResponse> response = restTemplate.exchange(uri, HttpMethod.POST, entity,
				GenerateNumberResponse.class);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		Assertions.assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
	}
}