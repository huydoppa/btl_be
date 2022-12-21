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
    @Column(name="bookId")
    private Long bookId;
    @Column(name="username")
    private String username;

    public Rating() {
    }

    public Rating(Long rating, Long bookId, String username) {
        this.id = id;
        Rating = rating;
        this.bookId = bookId;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
