package dev.shvetsova.books.client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class NewBookDto {
    @NotBlank(message = "Name cannot be empty or null")
    private String name;
    private String description;
    @PositiveOrZero
    private Integer published;
    @NotNull(message = "Authors cannot be null")
    @NotEmpty(message = "Authors cannot be empty")
    private List<Long> authors;
    private List<Long> genres;
}
