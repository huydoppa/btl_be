package com.example.demo.controller;

import com.example.demo.enitity.Comment;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/add")
    public ApiResponse addComment(@RequestBody Comment commentReq){
        Comment comment = new Comment(commentReq.getComment(), commentReq.getUsername(), commentReq.getbookId());
        commentRepository.save(comment);
        return new ApiResponse(0);
    }
    @GetMapping("/{bookId}")
    public ArrayList<Comment> getComment(@PathVariable String bookId){
        Long bookid = Long.parseLong(bookId);
        return commentRepository.findByBookId(bookid);
    }

}
