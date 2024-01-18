package org.app.fizzbuzzapp.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FizzBuzzApiTest {
    @Spy
    private FizzBuzzApi api;

    @Test
    @DisplayName("fetching delegate of FizzBuzz api returns of type FizzBuzzApiDelegate")
    void testGetDelegate(){
        final var result = assertDoesNotThrow(()->api.getDelegate());
        assertInstanceOf(FizzBuzzApiDelegate.class, result);
    }
}