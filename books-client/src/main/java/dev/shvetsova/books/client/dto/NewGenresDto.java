package dev.shvetsova.books.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewGenresDto {
    private List<String> name;
}
