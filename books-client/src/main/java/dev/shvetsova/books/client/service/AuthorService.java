package dev.shvetsova.books.client.service;

import dev.shvetsova.books.client.dto.NewAuthorDto;
import dev.shvetsova.books.client.wsdl.AuthorXsd;
import dev.shvetsova.books.client.wsdl.AuthorXsdList;

public interface AuthorService {
    AuthorXsd getAuthorByName(String name, String lastName);


    AuthorXsd getAuthorById(long id);

    AuthorXsdList getAllAuthors();

    AuthorXsd addNewAuthor(NewAuthorDto newAuthor);
}
