package com.clanz.test.controller;

import javax.validation.Valid;

import com.clanz.test.domain.dto.GenerateNumberRequest;
import com.clanz.test.domain.dto.GenerateNumberResponse;
import com.clanz.test.service.NumberService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class NumberController {
	private final NumberService numberService;

	@PostMapping(path = "/generate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenerateNumberResponse> generateNewNumber(@Valid @RequestBody GenerateNumberRequest requestDto) {

		return ResponseEntity.ok(numberService.getNumbers(requestDto));
	}
}
