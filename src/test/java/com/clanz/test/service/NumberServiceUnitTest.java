package com.clanz.test.service;

import com.clanz.test.domain.dto.GenerateNumberRequest;
import com.clanz.test.domain.dto.GenerateNumberResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NumberServiceUnitTest {

	@InjectMocks
	private NumberService numberService;

	@Test
	@Order(1)
	void generateNewNumbersWithValidCountShouldReturnOK() {
		GenerateNumberRequest requestDto = new GenerateNumberRequest();
		requestDto.setCount("3");
		GenerateNumberResponse numbers = numberService.getNumbers(requestDto);

		Assertions.assertThat(numbers.getNumbers().size()).isEqualTo(3);
	}

	@Test
	@Order(2)
	void generateNewNumbersWithNegativeCountShouldReturnBadRequest() {
		GenerateNumberRequest requestDto = new GenerateNumberRequest();
		requestDto.setCount("-2");
		org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()-> numberService.getNumbers(requestDto));
	}
}