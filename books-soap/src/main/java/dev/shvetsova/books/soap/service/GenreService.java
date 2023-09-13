package dev.shvetsova.books.soap.service;

import https.spring_io.guides.gs_producing_web_service.GenreXsd;
import https.spring_io.guides.gs_producing_web_service.GenreXsdList;

import java.util.List;

public interface GenreService {
    List<GenreXsd> getAllGenres();

    GenreXsdList addNewBook(List<String> genre);
}
