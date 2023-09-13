package dev.shvetsova.books.soap.repo;

import dev.shvetsova.books.soap.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByNameLikeIgnoreCase(String name);
    @Query(value = "Select b.* from books b " +
            "left join book_genres bg on bg.book_id= b.id " +
            "left join genres g on g.id=bg.genre_id " +
            "where g.name = ?", nativeQuery = true)
    List<Book> findByGenre(String genre);
}
