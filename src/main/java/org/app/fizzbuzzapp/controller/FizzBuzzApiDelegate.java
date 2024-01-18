package org.app.fizzbuzzapp.controller;

import jakarta.validation.Valid;
import lombok.Generated;
import org.app.fizzbuzzapp.model.FizzBuzz;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Generated
public interface FizzBuzzApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /fizzBuzz : Generate FizzBuzz pattern
     * Creates a FizzBuzz pattern
     *
     * @param fizzBuzz  (required)
     * @return successful operation (status code 201)
     *         or unexpected error (status code 200)
     * @see FizzBuzzApi#fizzBuzzPost
     */
    default ResponseEntity<String> fizzBuzzPost(@Valid FizzBuzz fizzBuzz) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/text"))) {
                    String exampleString = "\"1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz\"";
                    ApiUtil.setExampleResponse(request, "application/text", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
