package com.example.demo.repository;

import com.example.demo.enitity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    ArrayList<Rating> findByBookId(Long bookId);
}
