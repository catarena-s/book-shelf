package dev.shvetsova.books.client.service;

import dev.shvetsova.books.client.soap.SoapClient;
import dev.shvetsova.books.client.wsdl.AddGenreResponse;
import dev.shvetsova.books.client.wsdl.GenreXsd;
import dev.shvetsova.books.client.wsdl.GenreXsdList;
import dev.shvetsova.books.client.wsdl.GetAllGenresResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final SoapClient soapClient;

    @Override
    public GenreXsd getGenreByName(String name) {

        return null;
    }

    @Override
    public GenreXsd getGenreById(long id) {

        return null;
    }

    @Override
    public List<GenreXsd> getAllGenres() {
        GetAllGenresResponse response = soapClient.getAllGenres();
        return response.getGenre();
    }

    @Override
    public GenreXsdList addNewGenre(List<String> newGenre) {
        AddGenreResponse response = soapClient.addNewGenre(newGenre);
        return response.getGenres();
    }


}
