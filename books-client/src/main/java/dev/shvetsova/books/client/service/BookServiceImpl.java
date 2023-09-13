package dev.shvetsova.books.client.service;

import dev.shvetsova.books.client.dto.NewBookDto;
import dev.shvetsova.books.client.soap.SoapClient;
import dev.shvetsova.books.client.utils.Mapper;
import dev.shvetsova.books.client.wsdl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final SoapClient soapClient;

    @Override
    public BookXsd getBookByName(String name) {
        GetBookByNameResponse response = soapClient.getBookByName(name);
        return response.getBook();
    }

    @Override
    public BookXsdList getAllBooks() {
        GetAllBooksResponse response = soapClient.getAllBooks();
        return response.getBooks();
    }

    @Override
    public BookXsd getBookById(long id) {
        GetBookByIdResponse response = soapClient.getBookById(id);
        return response.getBook();
    }

    @Override
    public BookXsd addNewBook(NewBookDto newBookDto) {
        NewBookXsd newBookXsd = Mapper.toBookXsd(newBookDto);
        AddBookResponse addBookResponse = soapClient.addNewBook(newBookXsd);
        return addBookResponse.getBook();
    }

    @Override
    public BookXsdList getAllByGenre(String genre) {
        GetBookByGenreResponse response = soapClient.getBookByGenre(genre);
        return response.getBooks();
    }
}
