
package dev.shvetsova.books.client.soap;

import dev.shvetsova.books.client.wsdl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

@Slf4j
public class SoapClient extends WebServiceGatewaySupport {

    public GetBookByNameResponse getBookByName(String name) {
        GetBookByNameRequest request = new GetBookByNameRequest();
        request.setName(name);

        return (GetBookByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetAllBooksResponse getAllBooks() {
        GetAllBooksRequest request = new GetAllBooksRequest();
        return (GetAllBooksResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetBookByIdResponse getBookById(long id) {
        GetBookByIdRequest request = new GetBookByIdRequest();
        request.setId(id);

        return (GetBookByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public AddBookResponse addNewBook(NewBookXsd newBookXsd) {
        AddBookRequest request = new AddBookRequest();
        request.setNewBook(newBookXsd);

        return (AddBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetBookByGenreResponse getBookByGenre(String genre) {
        GetBookByGenreRequest request = new GetBookByGenreRequest();
        request.setGenre(genre);
        return (GetBookByGenreResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetAllGenresResponse getAllGenres() {
        GetAllGenresRequest request = new GetAllGenresRequest();
        return (GetAllGenresResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public AddAuthorResponse addNewAuthor(NewAuthorXsd newAuthorXsd) {
        AddAuthorRequest request = new AddAuthorRequest();
        request.setNewAuthor(newAuthorXsd);

        return (AddAuthorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetAuthorByNameResponse getAuthorByName(String name, String lastName) {
        GetAuthorByNameRequest request = new GetAuthorByNameRequest();
        request.setName(name);
        request.setLastName(lastName);

        return (GetAuthorByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetAuthorByIdResponse getAuthorById(long id) {
        GetAuthorByIdRequest request = new GetAuthorByIdRequest();
        request.setId(id);

        return (GetAuthorByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetAllAuthorsResponse getAllAuthors() {
        GetAllAuthorsRequest request = new GetAllAuthorsRequest();
        return (GetAllAuthorsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public AddGenreResponse addNewGenre(List<String> newGenres) {
        AddGenreRequest request = new AddGenreRequest();
        request.getGenre().addAll(newGenres);

        return (AddGenreResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
