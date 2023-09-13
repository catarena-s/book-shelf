package dev.shvetsova.books.soap.repo;

import dev.shvetsova.books.soap.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameLikeIgnoreCase(String name);

    boolean existsByNameAndLastNameAndFatherName(String name, String lastName, String fatherName);
}
