package com.clanz.test.controller;

import com.clanz.test.domain.dto.GenerateNumberRequestDto;
import com.clanz.test.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class NumberController {

    @GetMapping(value = "/generate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> generateNewNumber(
            @RequestBody GenerateNumberRequestDto requestDto
    ) {

        LinkedList<Integer> Numbers_Arrays = new LinkedList<>();

        for (int i = 0; i < requestDto.getCount(); i++) {
            int j = 4;
            int finalNumber = 0;
            while (true) {
                if (j < 0) {
                    break;
                }
                int Number = (int) Math.pow(j, 10) * NumberService.RandomNumber();
                finalNumber += Number;
                j--;
            }
            Numbers_Arrays.add(finalNumber);
        }

        for (var numbers_array : Numbers_Arrays) {
            System.out.println(numbers_array);
        }

        return ResponseEntity.ok(Numbers_Arrays);
    }
}
