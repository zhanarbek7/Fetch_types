package com.hibernate.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author_name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private List<Book> books;

    public Author(String author_name, List<Book> books) {
        this.author_name = author_name;
        this.books = books;
    }

    public Author() {
    }

    public List<Book> getBooks() {
        return books;
    }
}
