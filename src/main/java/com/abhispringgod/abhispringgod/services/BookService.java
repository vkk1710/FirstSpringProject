package com.abhispringgod.abhispringgod.services;


import com.abhispringgod.abhispringgod.models.Book;
import com.abhispringgod.abhispringgod.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }


    public Book getBook(String id) {
        List<Book> byId = bookRepo.findByAuthor(id);
//        if(byId.isPresent()) {
//            return byId.get();
//        }else {
//            return new Book();
        return byId.get(0);
        }


    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book book1 = bookRepo.findById(id).get();
        book1.setAuthor(book.getAuthor());
        book1.setName(book.getName());
        book1.setGenre(book.getGenre());
        return bookRepo.save(book1);

    }
}