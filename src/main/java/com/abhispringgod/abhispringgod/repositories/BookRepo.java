package com.abhispringgod.abhispringgod.repositories;

import com.abhispringgod.abhispringgod.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(nativeQuery = true, value = "Select * from books where author = q")
    List<Book> findByAuthor(String author);
}
