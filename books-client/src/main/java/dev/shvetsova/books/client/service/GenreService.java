package dev.shvetsova.books.client.service;

import dev.shvetsova.books.client.wsdl.GenreXsd;
import dev.shvetsova.books.client.wsdl.GenreXsdList;

import java.util.List;

public interface GenreService {
    GenreXsd getGenreByName(String name);

    GenreXsd getGenreById(long id);

    List<GenreXsd> getAllGenres();

    GenreXsdList addNewGenre(List<String> newGenre);
}
