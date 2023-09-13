package dev.shvetsova.books.client.service;

import dev.shvetsova.books.client.dto.NewBookDto;
import dev.shvetsova.books.client.wsdl.BookXsd;
import dev.shvetsova.books.client.wsdl.BookXsdList;

public interface BookService {
    BookXsd getBookByName(String name);

    BookXsdList getAllBooks();

    BookXsd getBookById(long id);

    BookXsd addNewBook(NewBookDto newBookXsd);

    BookXsdList getAllByGenre(String genre);
}
