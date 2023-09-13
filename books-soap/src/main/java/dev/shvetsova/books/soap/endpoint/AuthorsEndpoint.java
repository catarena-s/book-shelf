package dev.shvetsova.books.soap.endpoint;

import dev.shvetsova.books.soap.service.AuthorService;
import https.spring_io.guides.gs_producing_web_service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static dev.shvetsova.books.soap.utils.Constants.TARGET_NAMESPACE;

@Endpoint
@RequiredArgsConstructor
public class AuthorsEndpoint {

    private final AuthorService authorService;

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getAllAuthorsRequest")
    @ResponsePayload
    public GetAllAuthorsResponse getAllAuthors() {
        GetAllAuthorsResponse response = new GetAllAuthorsResponse();
        AuthorXsdList authors = authorService.getAll();
        response.setAuthors(authors);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getAuthorByIdRequest")
    @ResponsePayload
    public GetAuthorByIdResponse getAuthorById(@RequestPayload GetAuthorByIdRequest request) {
        GetAuthorByIdResponse response = new GetAuthorByIdResponse();
        AuthorXsd author = authorService.getById(request.getId());
        response.setAuthor(author);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getAuthorByNameRequest")
    @ResponsePayload
    public GetAuthorByNameResponse getAuthorByName(@RequestPayload GetAuthorByNameRequest request) {
        GetAuthorByNameResponse response = new GetAuthorByNameResponse();
        AuthorXsd author = authorService.getByName(request.getName());
        response.setAuthor(author);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "addAuthorRequest")
    @ResponsePayload
    public AddAuthorResponse addAuthor(@RequestPayload AddAuthorRequest request) {
        AddAuthorResponse response = new AddAuthorResponse();
        AuthorXsd author = authorService.addAuthor(request.getNewAuthor());
        response.setAuthor(author);
        return response;
    }
}
