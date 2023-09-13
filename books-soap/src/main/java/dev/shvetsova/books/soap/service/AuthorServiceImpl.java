package dev.shvetsova.books.soap.service;

import dev.shvetsova.books.soap.exceptions.ConflictException;
import dev.shvetsova.books.soap.model.Author;
import dev.shvetsova.books.soap.repo.AuthorRepository;
import dev.shvetsova.books.soap.utils.Converter;
import https.spring_io.guides.gs_producing_web_service.AuthorXsd;
import https.spring_io.guides.gs_producing_web_service.AuthorXsdList;
import https.spring_io.guides.gs_producing_web_service.NewAuthorXsd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    @Override

    public AuthorXsdList getAll() {
        List<Author> authors = repository.findAll();
        return Converter.toAuthorXsdList(authors);
    }

    @Override
    public AuthorXsd getByName(String name) {
        Author author = repository.findByNameLikeIgnoreCase(name).orElseThrow();
        return Converter.toAuthorXsd(author);
    }

    @Override
    public AuthorXsd getById(long id) {
        Author author = repository.findById(id).orElseThrow();
        return Converter.toAuthorXsd(author);
    }

    @Override
    @Transactional
    public AuthorXsd addAuthor(NewAuthorXsd newAuthor) {
        boolean isExistAuthor = repository.existsByNameAndLastNameAndFatherName(newAuthor.getName(), newAuthor.getLastName(), newAuthor.getFatherName());
        if (isExistAuthor) {
            throw new ConflictException(String.format("Author with name:%s %s %s - already exist", newAuthor.getName(), newAuthor.getLastName(), newAuthor.getFatherName()));
        }
        Author author = Converter.fromAuthorXsd(newAuthor);
        repository.save(author);
        return Converter.toAuthorXsd(author);
    }
}
