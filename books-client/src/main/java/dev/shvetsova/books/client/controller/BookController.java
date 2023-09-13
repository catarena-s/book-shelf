package dev.shvetsova.books.client.controller;

import dev.shvetsova.books.client.dto.NewBookDto;
import dev.shvetsova.books.client.service.BookService;
import dev.shvetsova.books.client.wsdl.BookXsd;
import dev.shvetsova.books.client.wsdl.BookXsdList;
import dev.shvetsova.books.client.wsdl.NewBookXsd;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    BookXsd getBookByName(@RequestParam String name) {
        return service.getBookByName(name);
    }

    @GetMapping("/{id}")
    BookXsd getBookById(@PathVariable long id) {
        return service.getBookById(id);
    }

    @GetMapping("/all")
    BookXsdList getAllBooks(@RequestParam(required = false) String genre) {
        if (genre == null || genre.isBlank()) return service.getAllBooks();
        return service.getAllByGenre(genre);
    }

    @PostMapping
    BookXsd addBook(@RequestBody NewBookDto newBookDto) {
        return service.addNewBook(newBookDto);
    }

}
