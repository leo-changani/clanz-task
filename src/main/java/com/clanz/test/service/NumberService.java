package com.clanz.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NumberService {

    public static int RandomNumber() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        var Index = new Random().nextInt(0, 9);
        return array[Index];
    }
}
