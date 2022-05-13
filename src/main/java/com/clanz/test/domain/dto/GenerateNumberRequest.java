package com.clanz.test.domain.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class GenerateNumberRequest {

	@Pattern(regexp = "^\\d+$")
	private String count;
}
