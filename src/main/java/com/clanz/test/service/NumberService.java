package com.clanz.test.service;

import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.validation.Valid;

import com.clanz.test.domain.dto.GenerateNumberRequest;
import com.clanz.test.domain.dto.GenerateNumberResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberService {

	public GenerateNumberResponse getNumbers(@Valid GenerateNumberRequest requestDto) {

		if (Integer.parseInt(requestDto.getCount()) < 0) {
			throw new IllegalArgumentException();
		}
		ArrayList<Integer> numbersArrays = new ArrayList<>();

		int j;
		for (int i = 0; i < Integer.parseInt(requestDto.getCount()); i++) {
			j = 4;
			int finalNumber = 0;
			while (j > 0) {
				int number = (int) Math.pow(j, 10) * randomNumber();
				finalNumber += number;
				j--;
			}
			numbersArrays.add(finalNumber);
		}

		for (var numbersArray : numbersArrays) {
			System.out.println(numbersArray);
		}
		GenerateNumberResponse response = new GenerateNumberResponse();
		response.setNumbers(numbersArrays);
		return response;

	}

	private int randomNumber() {
		int[] array = new int[9];
		IntStream.rangeClosed(1, 9).forEach(i -> array[i - 1] = i);
		var Index = (int) ((Math.random() * (9)));
		return array[Index];
	}
}
