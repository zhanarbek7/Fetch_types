package com.hibernate;

import com.hibernate.config.DbConnection;
import com.hibernate.entities.Author;
import com.hibernate.entities.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {

    /**
     * 1. If we put lazy fetch type on List<Book>
     * then we don't get books along with author,
     * we can access books of author till entityManager is not closed
     * or with other method
     * 2. In case if we put eager fetch type on List<Book>
     * then we get books along with author,
     * but this is not performant
     */

    public static void main(String[] args) {

        Book book1 = new Book("Harry Potter 1");
        Book book2 = new Book("Harry Potter 2");
        Book book3 = new Book("Harry Potter 3");

        Author author = new Author("Zhanarbek",
                List.of(book1, book2, book3));
        Author author1 = getAuthor(1L);
        System.out.println(author1.getBooks());


    }

    public static void saveAuthorWithBooks(Author author){
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public static Author getAuthor(Long id){
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, 1L);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }
}