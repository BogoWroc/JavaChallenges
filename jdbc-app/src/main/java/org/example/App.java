package org.example;

import org.example.model.Book;
import org.example.repository.BookDao;
import org.example.repository.Dao;

import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Dao<Book> bookDao = new BookDao();

        System.out.println("#### Find all books ####");
        List<Book> books = bookDao.findAll();
        books.forEach(System.out::println);
        System.out.println("#### END ####");

        System.out.println("#### Find by ID ####");
        Optional<Book> book = bookDao.findById(1);
        book.ifPresentOrElse(System.out::println, () -> System.out.println("The book does not exist!"));
        System.out.println("#### END ####");

        System.out.println("#### Create ####");
        Book newBook = new Book();
        newBook.setTitle("Orly imperium: Kohorta");
        newBook = bookDao.create(newBook);

        book = bookDao.findById(newBook.getId());
        book.ifPresentOrElse(System.out::println, () -> System.out.println("The book does not exist!"));
        System.out.println("#### END ####");



        System.out.println("#### Batch update ####");
        List<Book> books1 = books.stream().peek(it -> it.setRating(5)).toList();
        bookDao.update(books1);

        books = bookDao.findAll();
        books.forEach(System.out::println);
        System.out.println("#### END ####");

        System.out.println("#### Delete ####");
        book = bookDao.findById(newBook.getId());
        int numDeleted = bookDao.delete(book.orElseThrow());
        System.out.println("Number of records deleted: "+ numDeleted);
        System.out.println("#### END ####");

        System.out.println("Current state of db: ");
        books = bookDao.findAll();
        books.forEach(System.out::println);

    }
}
