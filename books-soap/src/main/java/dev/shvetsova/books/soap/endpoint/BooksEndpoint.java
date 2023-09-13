package dev.shvetsova.books.soap.endpoint;

import dev.shvetsova.books.soap.service.BookService;
import https.spring_io.guides.gs_producing_web_service.*;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static dev.shvetsova.books.soap.utils.Constants.TARGET_NAMESPACE;

@Endpoint
@RequiredArgsConstructor
public class BooksEndpoint {
    private final BookService bookService;

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getBookByNameRequest")
    @ResponsePayload
    public GetBookByNameResponse getBookByName(@RequestPayload GetBookByNameRequest request) throws JAXBException {
        GetBookByNameResponse response = new GetBookByNameResponse();
        BookXsd book = bookService.findBook(request.getName());
        response.setBook(book);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getBookByIdRequest")
    @ResponsePayload
    public GetBookByIdResponse getBookById(@RequestPayload GetBookByIdRequest request) {
        GetBookByIdResponse response = new GetBookByIdResponse();
        BookXsd book = bookService.findBook(request.getId());
        response.setBook(book);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getBookByGenreRequest")
    @ResponsePayload
    public GetBookByGenreResponse getBookByGenre(@RequestPayload GetBookByGenreRequest request) {
        GetBookByGenreResponse response = new GetBookByGenreResponse();
        BookXsdList book = bookService.findBookByGenre(request.getGenre());
        response.setBooks(book);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getAllBooksRequest")
    @ResponsePayload
    public GetAllBooksResponse getAllBooks() {
        GetAllBooksResponse response = new GetAllBooksResponse();
        BookXsdList books = bookService.getAllBooks();
        response.setBooks(books);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        AddBookResponse response = new AddBookResponse();
        BookXsd book = bookService.addNewBook(request.getNewBook());
        response.setBook(book);
        return response;
    }
}
