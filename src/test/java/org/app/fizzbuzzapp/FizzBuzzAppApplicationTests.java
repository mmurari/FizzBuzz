package org.app.fizzbuzzapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.app.fizzbuzzapp.controller.FizzBuzzController;
import org.app.fizzbuzzapp.model.FizzBuzz;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class FizzBuzzAppApplicationTests {

    @Autowired
    private FizzBuzzController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("Fizz Buzz post api call with valid input")
    void fizzBuzzPostShouldReturnSuccess() throws Exception {
        final var input = new FizzBuzz(3, 5, 15, "fizz", "buzz");
        final var content = mapper.writeValueAsString(input);
        final var request = post("http://localhost:"+port+"/fizzBuzz")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        final var expected = "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz";

        this.mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(Matchers.containsString(expected)));
    }

    @Test
    @DisplayName("Fizz Buzz post api call with inValid Client input")
    void fizzBuzzPostShouldReturnError() throws Exception {
        final var input = new FizzBuzz(0, 0, 15, "fizz", "buzz");
        final var content = mapper.writeValueAsString(input);
        final var request = post("http://localhost:"+port+"/fizzBuzz")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        final var expected = 400;

        this.mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content()
                        .string(Matchers.containsString(String.valueOf(expected))));
    }

}
