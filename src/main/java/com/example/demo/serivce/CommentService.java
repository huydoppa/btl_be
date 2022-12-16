package com.example.demo.serivce;


import com.example.demo.enitity.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComment(){
        List<Comment> cmt = commentRepository.findAll();
        return cmt;
    }
}
