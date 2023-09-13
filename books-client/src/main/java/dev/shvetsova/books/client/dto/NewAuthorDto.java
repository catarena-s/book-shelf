package dev.shvetsova.books.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static dev.shvetsova.books.client.utils.Constants.DD_MM_YYYY;

@Data
public class NewAuthorDto {
    @NotBlank(message = "Name cannot be empty or null")
    private String name;
    @NotBlank(message = "lastName cannot be empty or null")
    private String lastName;
    private String fatherName;
    @JsonFormat(pattern = DD_MM_YYYY)
    private String  birthDay;
    @JsonFormat(pattern = DD_MM_YYYY)
    private String deadDay;
    private String description;
}
