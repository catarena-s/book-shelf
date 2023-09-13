package dev.shvetsova.books.soap.service;

import dev.shvetsova.books.soap.exceptions.NotFoundException;
import dev.shvetsova.books.soap.model.Author;
import dev.shvetsova.books.soap.model.Book;
import dev.shvetsova.books.soap.model.Genre;
import dev.shvetsova.books.soap.repo.AuthorRepository;
import dev.shvetsova.books.soap.repo.BookRepository;
import dev.shvetsova.books.soap.repo.GenreRepository;
import dev.shvetsova.books.soap.utils.Converter;
import https.spring_io.guides.gs_producing_web_service.BookXsd;
import https.spring_io.guides.gs_producing_web_service.BookXsdList;
import https.spring_io.guides.gs_producing_web_service.ListIdsXsd;
import https.spring_io.guides.gs_producing_web_service.NewBookXsd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public BookXsd findBook(String name) {
        Book book = bookRepository.findByNameLikeIgnoreCase(name);
        return Converter.toBookXsd(book);
    }

    @Override
    public BookXsdList getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return allBooks.isEmpty() ? new BookXsdList() : Converter.toBookXsdList(allBooks);
    }

    @Override

    public BookXsd findBook(long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return Converter.toBookXsd(book);
    }

    @Override
    public BookXsdList findBookByGenre(String genre) {
        List<Book> books = bookRepository.findByGenre(genre);
        return books.isEmpty()
                ? new BookXsdList()
                : Converter.toBookXsdList(books);
    }

    @Override
    @Transactional
    public BookXsd addNewBook(NewBookXsd newBookXsd) {
        Book book = Converter.fromBookXsd(newBookXsd);
        if (newBookXsd.getAuthors() != null && !newBookXsd.getAuthors().getId().isEmpty()) {
            ListIdsXsd authors = newBookXsd.getAuthors();
            List<Author> authorList = authorRepository.findAllById(authors.getId());
            if (authorList.isEmpty()) {
                throw new NotFoundException(
                        String.format("Authors with ids:[%s] doesn't exist",
                                String.join(",", authors.getId().stream().map(String::valueOf).toList())));
            }
            book.setAuthors(authorList);
        }
        if (newBookXsd.getGenres() != null && !newBookXsd.getGenres().getId().isEmpty()) {
            ListIdsXsd genres = newBookXsd.getGenres();
            List<Genre> genreList = genreRepository.findAllById(genres.getId());
            book.setGenres(new HashSet<>(genreList));
        }
        bookRepository.save(book);
        return Converter.toBookXsd(book);
    }
}
