package org.app.fizzbuzzapp.controller;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Generated
@Controller
@RequestMapping("/")
public class FizzBuzzController implements FizzBuzzApi {

    private final FizzBuzzApiDelegate delegate;

    public FizzBuzzController(@Autowired(required = false) FizzBuzzApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FizzBuzzApiDelegate() {
        });
    }

    @Override
    public FizzBuzzApiDelegate getDelegate() {
        return delegate;
    }

}

