package dev.shvetsova.books.soap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "birth_day")
    private LocalDate birthDay;
    @Column(name = "dead_day")
    private LocalDate deadDay;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_authors",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Collection<Book> books;

    public String getFullName() {
        return fatherName == null
                ? String.join(" ", lastName, name)
                : String.join(" ", lastName, name, fatherName);
    }
}
