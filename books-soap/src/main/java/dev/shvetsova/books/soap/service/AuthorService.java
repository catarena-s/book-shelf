package dev.shvetsova.books.soap.service;

import https.spring_io.guides.gs_producing_web_service.AuthorXsd;
import https.spring_io.guides.gs_producing_web_service.AuthorXsdList;
import https.spring_io.guides.gs_producing_web_service.NewAuthorXsd;

public interface AuthorService {
    AuthorXsdList getAll();

    AuthorXsd getByName(String name);

    AuthorXsd getById(long id);

    AuthorXsd addAuthor(NewAuthorXsd newAuthor);
}
