package dev.shvetsova.books.client.utils;

import dev.shvetsova.books.client.dto.NewAuthorDto;
import dev.shvetsova.books.client.dto.NewBookDto;
import dev.shvetsova.books.client.wsdl.ListIdsXsd;
import dev.shvetsova.books.client.wsdl.NewAuthorXsd;
import dev.shvetsova.books.client.wsdl.NewBookXsd;

import java.util.List;

public class Mapper {
    public static NewAuthorXsd toAuthorXsd(NewAuthorDto newAuthor) {
        NewAuthorXsd authorXsd = new NewAuthorXsd();
        authorXsd.setName(newAuthor.getName());
        authorXsd.setLastName(newAuthor.getLastName());
        if (newAuthor.getFatherName() != null) authorXsd.setFatherName(newAuthor.getFatherName());
        if (newAuthor.getDescription() != null) authorXsd.setDescription(newAuthor.getDescription());
        if (newAuthor.getDeadDay() != null) authorXsd.setDeadDay(newAuthor.getDeadDay());
        if (newAuthor.getBirthDay() != null) authorXsd.setBirthDay(newAuthor.getBirthDay());
        return authorXsd;
    }

    public static NewBookXsd toBookXsd(NewBookDto newBookDto) {
        NewBookXsd bookXsd = new NewBookXsd();
        bookXsd.setName(newBookDto.getName());
        if (newBookDto.getPublished() != null) {
            bookXsd.setPublished(newBookDto.getPublished());
        }
        if (newBookDto.getDescription() != null) bookXsd.setDescription(newBookDto.getDescription());
        bookXsd.setAuthors(Mapper.toListIdXsd(newBookDto.getAuthors()));
        if (newBookDto.getGenres() != null && !newBookDto.getGenres().isEmpty())
            bookXsd.setGenres(Mapper.toListIdXsd(newBookDto.getGenres()));
        return bookXsd;
    }

    private static ListIdsXsd toListIdXsd(List<Long> listIds) {
        ListIdsXsd listIdsXsd = new ListIdsXsd();
        listIdsXsd.getId().addAll(listIds);
        return listIdsXsd;
    }
}
