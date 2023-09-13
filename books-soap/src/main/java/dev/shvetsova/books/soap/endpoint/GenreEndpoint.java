package dev.shvetsova.books.soap.endpoint;

import dev.shvetsova.books.soap.service.GenreService;
import https.spring_io.guides.gs_producing_web_service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

import static dev.shvetsova.books.soap.utils.Constants.TARGET_NAMESPACE;

@Endpoint
@RequiredArgsConstructor
public class GenreEndpoint {
    private final GenreService genreService;


    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getAllGenresRequest")
    @ResponsePayload
    public GetAllGenresResponse getAllGenres() {
        GetAllGenresResponse response = new GetAllGenresResponse();
        List<GenreXsd> genres = genreService.getAllGenres();
        response.getGenre().addAll(genres);
        return response;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "addGenreRequest")
    @ResponsePayload
    public AddGenreResponse addGenre(@RequestPayload AddGenreRequest request) {
        AddGenreResponse response = new AddGenreResponse();
        GenreXsdList genres = genreService.addNewBook(request.getGenre());
        response.setGenres(genres);
        return response;
    }
}
