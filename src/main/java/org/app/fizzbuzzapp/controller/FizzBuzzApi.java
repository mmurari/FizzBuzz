package org.app.fizzbuzzapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Generated;
import org.app.fizzbuzzapp.model.FizzBuzz;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Generated
@Validated
@Tag(name = "fizzbuzz", description = "Generate FizzBuzz")
public interface FizzBuzzApi {

    default FizzBuzzApiDelegate getDelegate() {
        return new FizzBuzzApiDelegate() {
        };
    }

    /**
     * POST /fizzBuzz : Generate FizzBuzz pattern
     * Creates a FizzBuzz pattern
     *
     * @param fizzBuzz (required)
     * @return successful operation (status code 201)
     * or unexpected error (status code 200)
     */
    @Operation(
            operationId = "fizzBuzzPost",
            summary = "Generate FizzBuzz pattern",
            description = "Creates a FizzBuzz pattern",
            tags = {"fizzbuzz"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/text", schema = @Schema(implementation = String.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/fizzBuzz",
            produces = {"application/text", "application/json"},
            consumes = {"application/json"}
    )

    default ResponseEntity<String> fizzBuzzPost(
            @Parameter(name = "FizzBuzz", description = "creates a fizzbuzz text", required = true) @Valid @RequestBody FizzBuzz fizzBuzz
    ) {
        return getDelegate().fizzBuzzPost(fizzBuzz);
    }

}