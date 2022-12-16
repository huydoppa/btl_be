package com.example.demo.payload;


import com.example.demo.enitity.Comment;

import java.util.List;

public class CommentResponse {
    private List<Comment> comments;
    public CommentResponse(List<Comment> comments) {

        this.comments = comments;
    }
}
