package com.clanz.test.service;

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
    void generateNewNumbersWithValidCountShouldReturnOK() throws Exception {

    }

    @Test
    @Order(2)
    void generateNewNumbersWithNegativeCountShouldReturnBadRequest() throws Exception {

    }
}