package dev.shvetsova.books.soap.service;

import dev.shvetsova.books.soap.model.Genre;
import dev.shvetsova.books.soap.repo.GenreRepository;
import dev.shvetsova.books.soap.utils.Converter;
import https.spring_io.guides.gs_producing_web_service.GenreXsd;
import https.spring_io.guides.gs_producing_web_service.GenreXsdList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GenreXsd> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(Converter::toGenreXsd).toList();
    }

    @Override
    @Transactional
    public GenreXsdList addNewBook(List<String> newGenres) {
        List<Genre> genres = new ArrayList<>();
        newGenres.forEach(x -> genres.add(Converter.toGenre(x)));
        genreRepository.saveAll(genres);
        return Converter.toGenreXsdList(genres);
    }
}
