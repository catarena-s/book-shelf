package dev.shvetsova.books.soap.service;


import https.spring_io.guides.gs_producing_web_service.BookXsd;
import https.spring_io.guides.gs_producing_web_service.BookXsdList;
import https.spring_io.guides.gs_producing_web_service.NewBookXsd;
import jakarta.xml.bind.JAXBException;

public interface BookService {
    BookXsd findBook(String name) throws JAXBException;

    BookXsdList getAllBooks();

    BookXsd findBook(long id);

    BookXsdList findBookByGenre(String genre);

    BookXsd addNewBook(NewBookXsd newBookXsd);
}
