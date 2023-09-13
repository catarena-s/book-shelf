package dev.shvetsova.books.client.controller;

import dev.shvetsova.books.client.dto.NewGenresDto;
import dev.shvetsova.books.client.service.GenreService;
import dev.shvetsova.books.client.wsdl.GenreXsd;
import dev.shvetsova.books.client.wsdl.GenreXsdList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService service;

    @GetMapping
    List<GenreXsd> getAllGenres() {
        return service.getAllGenres();
    }

    @PostMapping
    GenreXsdList addGenre(@RequestBody NewGenresDto newGenre) {
        return service.addNewGenre(newGenre.getName());
    }

}
