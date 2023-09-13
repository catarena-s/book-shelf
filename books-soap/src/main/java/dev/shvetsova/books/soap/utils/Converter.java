package dev.shvetsova.books.soap.utils;

import dev.shvetsova.books.soap.model.Author;
import dev.shvetsova.books.soap.model.Book;
import dev.shvetsova.books.soap.model.Genre;
import https.spring_io.guides.gs_producing_web_service.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static dev.shvetsova.books.soap.utils.Constants.FORMATTER;

public class Converter {
    public static BookXsd toBookXsd(Book book) {
        BookXsd bookXsd = new BookXsd();
        bookXsd.setId(book.getId());
        bookXsd.setName(book.getName());
        bookXsd.setDescription(book.getDescription());
        if (book.getPublished() != null) {
            bookXsd.setPublished(book.getPublished());
        }

        AuthorXsdShortList authorList = new AuthorXsdShortList();
        List<AuthorXsdShort> authors = book.getAuthors().stream().map(Converter::toAuthorXsdShort).toList();
        authorList.getAuthor().addAll(authors);
        bookXsd.setAuthors(authorList);

        if (book.getGenres() != null && !book.getGenres().isEmpty()) {
            GenreXsdList genreXsdList = new GenreXsdList();
            List<GenreXsd> genres = book.getGenres().stream().map(Converter::toGenreXsd).toList();
            genreXsdList.getGenre().addAll(genres);
            bookXsd.setGenres(genreXsdList);
        }

        return bookXsd;
    }

    public static GenreXsd toGenreXsd(Genre genre) {
        GenreXsd xsd = new GenreXsd();
        xsd.setId(genre.getId());
        xsd.setName(genre.getName());
        return xsd;
    }

    private static AuthorXsdShort toAuthorXsdShort(Author author) {
        AuthorXsdShort authorShort = new AuthorXsdShort();
        authorShort.setId(author.getId());
        authorShort.setName(author.getFullName());
        return authorShort;
    }

    public static BookXsdList toBookXsdList(List<Book> allBooks) {
        BookXsdList bookXsdList = new BookXsdList();
        bookXsdList.getBook().addAll(allBooks.stream().map(Converter::toBookXsd).toList());
        return bookXsdList;
    }

    public static Book fromBookXsd(NewBookXsd newBookXsd) {
        Book book = new Book();
        book.setName(newBookXsd.getName());
        if (newBookXsd.getPublished() != 0) {
            book.setPublished(newBookXsd.getPublished());
        }
        if (newBookXsd.getDescription() != null && !newBookXsd.getDescription().isBlank()) {
            book.setDescription(newBookXsd.getDescription());
        }
        return book;
    }

    public static Genre toGenre(String genreName) {
        Genre genre = new Genre();
        genre.setName(genreName);
        return genre;
    }

    public static GenreXsdList toGenreXsdList(List<Genre> genres) {
        GenreXsdList genreXsdList = new GenreXsdList();
        genreXsdList.getGenre().addAll(genres.stream().map(Converter::toGenreXsd).toList());
        return genreXsdList;
    }

    public static AuthorXsdList toAuthorXsdList(List<Author> authors) {
        AuthorXsdList authorXsdList = new AuthorXsdList();
        authorXsdList.getAuthor().addAll(authors.stream().map(Converter::toAuthorXsd).toList());
        return authorXsdList;
    }

    private static BookXsdShortList toBookXsdShortList(Collection<Book> books) {
        BookXsdShortList bookXsdShortList = new BookXsdShortList();
        bookXsdShortList.getBook().addAll(books.stream().map(Converter::toBookXsdShort).toList());
        return bookXsdShortList;
    }

    private static BookXsdShort toBookXsdShort(Book book) {
        BookXsdShort bookXsdShort = new BookXsdShort();
        bookXsdShort.setId(book.getId());
        bookXsdShort.setName(book.getName());
        return bookXsdShort;
    }

    public static AuthorXsd toAuthorXsd(Author author) {
        AuthorXsd authorXsd = new AuthorXsd();
        authorXsd.setId(author.getId());
        authorXsd.setName(author.getName());
        if (author.getLastName() != null) authorXsd.setLastName(author.getLastName());
        if (author.getFatherName() != null) authorXsd.setFatherName(author.getFatherName());
        if (author.getDescription() != null) authorXsd.setDescription(author.getDescription());

        if (author.getDeadDay() != null) authorXsd.setDeadDay(author.getDeadDay().format(FORMATTER));
        if (author.getBirthDay() != null) authorXsd.setBirthDay(author.getBirthDay().format(FORMATTER));

        if (author.getBooks() != null && !author.getBooks().isEmpty()) {
            authorXsd.setBooks(Converter.toBookXsdShortList(author.getBooks()));
        }
        return authorXsd;
    }

    public static Author fromAuthorXsd(NewAuthorXsd newAuthor) {
        Author author = new Author();
        author.setName(newAuthor.getName());
        author.setLastName(newAuthor.getLastName());
        if (newAuthor.getFatherName() != null) author.setFatherName(newAuthor.getFatherName());
        if (newAuthor.getDescription() != null) author.setDescription(newAuthor.getDescription());

        if (newAuthor.getDeadDay() != null) author.setDeadDay(LocalDate.parse(newAuthor.getDeadDay(), FORMATTER));
        if (newAuthor.getBirthDay() != null) author.setBirthDay(LocalDate.parse(newAuthor.getBirthDay(), FORMATTER));

        return author;
    }

}
