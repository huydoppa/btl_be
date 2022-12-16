package com.example.demo.enitity;

import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="comment")
    private String Comment;

    @Column(name="username")
    private String username ;
    @Column(name="bookId")
    private Long bookId;

    public Comment(){

    }

    public Comment(String Comment, String username ,Long bookId){
        this.Comment = Comment;
        this.username = username;
        this.bookId = bookId;
    }

    public Long getbookId() {
        return bookId;
    }

    public void setbookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
