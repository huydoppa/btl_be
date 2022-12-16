package com.example.demo.enitity;

import javax.persistence.*;

@Entity
@Table(name="Rating")


public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Rating")
    private Long Rating;
    @Column(name="book_id")
    private Long book_id;
    @Column(name="username")
    private String username;

    public Rating() {
    }

    public Rating(Long rating, Long book_id, String username) {
        this.id = id;
        Rating = rating;
        this.book_id = book_id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRating() {
        return Rating;
    }

    public void setRating(Long rating) {
        Rating = rating;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
