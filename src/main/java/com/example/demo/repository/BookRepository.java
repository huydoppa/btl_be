package com.example.demo.repository;

import com.example.demo.enitity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select p from Book p")
    ArrayList<Book> getAllBook();

    @Query("delete from Book where id=?1")
    void delete();

 //   Book GetById(Long Id);

}
