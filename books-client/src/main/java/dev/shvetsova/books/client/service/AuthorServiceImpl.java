package dev.shvetsova.books.client.service;

import dev.shvetsova.books.client.dto.NewAuthorDto;
import dev.shvetsova.books.client.soap.SoapClient;
import dev.shvetsova.books.client.utils.Mapper;
import dev.shvetsova.books.client.wsdl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final SoapClient soapClient;

    @Override
    public AuthorXsd getAuthorByName(String name, String lastName) {
        GetAuthorByNameResponse response = soapClient.getAuthorByName(name, lastName);
        return response.getAuthor();
    }

    @Override
    public AuthorXsd getAuthorById(long id) {
        GetAuthorByIdResponse response = soapClient.getAuthorById(id);
        return response.getAuthor();
    }

    @Override
    public AuthorXsdList getAllAuthors() {
        GetAllAuthorsResponse response = soapClient.getAllAuthors();
        return response.getAuthors();
    }

    @Override
    public AuthorXsd addNewAuthor(NewAuthorDto newAuthor) {
        NewAuthorXsd newAuthorXsd = Mapper.toAuthorXsd(newAuthor);
        AddAuthorResponse response = soapClient.addNewAuthor(newAuthorXsd);
        return response.getAuthor();
    }
}
