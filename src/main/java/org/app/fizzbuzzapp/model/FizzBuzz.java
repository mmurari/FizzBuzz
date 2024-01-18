package org.app.fizzbuzzapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record FizzBuzz(
        @NotNull(message = "int1 can't be null")
        @Min(value = 1, message = "int1 minimum value is 1")
        @Max(value = 1000, message = "int1 maximum value is 1000")
        @Schema(name = "int1", example = "3", requiredMode = REQUIRED)
        int int1,
        @NotNull(message = "int2 can't be null")
        @Min(value = 1, message = "int2 minimum value is 1")
        @Max(value = 1000, message = "int2 maximum value is 1000")
        @Schema(name = "int2", example = "5", requiredMode = REQUIRED)
        int int2,
        @NotNull(message = "limit can't be null")
        @Min(value = 1, message = "limit minimum value is 1")
        @Max(value = 1000, message = "limit maximum value is 1000")
        @Schema(name = "int2", example = "5", requiredMode = REQUIRED)
        int limit,
        @NotNull(message = "str1 can't be null")
        @Pattern(regexp = "^\\w+", message = " value of str1 should obey the regex for word")
        @Size(min = 1, max = 20, message = "str1 length should be between 1 and 20 characters")
        @Schema(name = "str1", example = "fizz", requiredMode = REQUIRED)
        String str1,
        @NotNull(message = "str2 can't be null")
        @Pattern(regexp = "^\\w+", message = "value of str2 should obey the regex for word")
        @Size(min = 1, max = 20, message = "str2 length should be between 1 and 20 characters")
        @Schema(name = "str2", example = "buzz", requiredMode = REQUIRED)
        String str2
) {
}
