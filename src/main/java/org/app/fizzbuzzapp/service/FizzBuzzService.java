package org.app.fizzbuzzapp.service;

import lombok.extern.slf4j.Slf4j;
import org.app.fizzbuzzapp.controller.FizzBuzzApiDelegate;
import org.app.fizzbuzzapp.model.FizzBuzz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class FizzBuzzService implements FizzBuzzApiDelegate {
    @Override
    public ResponseEntity<String> fizzBuzzPost(FizzBuzz input) {
        log.info("received input: {}", input);
        final var result = IntStream.rangeClosed(1, input.limit())
                .mapToObj(FizzBuzzGenerator.apply(input))
                .collect(Collectors.joining(","));
        log.info("output: {}",result);
        return ResponseEntity.ok(result);
    }

    Function<FizzBuzz, IntFunction<String>> FizzBuzzGenerator = input -> number -> {
        if (0 == number % input.int1() && 0 == number % input.int2())
            return input.str1().concat(input.str2());
        else if (0 == number % input.int1()) return input.str1();
        else if (0 == number % input.int2()) return input.str2();
        else return String.valueOf(number);
    };
}
