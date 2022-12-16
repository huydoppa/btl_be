package com.example.demo.repository;

import com.example.demo.enitity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    ArrayList<Comment> findByBookId(Long bookId);
}
