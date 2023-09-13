package dev.shvetsova.books.client.controller;

import dev.shvetsova.books.client.dto.NewAuthorDto;
import dev.shvetsova.books.client.service.AuthorService;
import dev.shvetsova.books.client.wsdl.AuthorXsd;
import dev.shvetsova.books.client.wsdl.AuthorXsdList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping
    AuthorXsd getBookByName(@RequestParam String name,
                            @RequestParam(required = false) String lastName) {
        return service.getAuthorByName(name, lastName);
    }

    @GetMapping("/{id}")
    AuthorXsd getAuthorById(@PathVariable long id) {
        return service.getAuthorById(id);
    }

    @GetMapping("/all")
    AuthorXsdList getAllBooks() {
        return service.getAllAuthors();
    }

    @PostMapping
    AuthorXsd addBook(@RequestBody NewAuthorDto newAuthor) {
        return service.addNewAuthor(newAuthor);
    }

}
