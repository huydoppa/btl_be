package com.example.demo.controller;

import com.example.demo.enitity.Rating;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/rate")
public class RatingController {
    @Autowired
    RatingRepository ratingRepository;

    @PostMapping("/create")
    public ApiResponse create(@RequestBody Rating ratingReq){
        try {
            Rating rating = new Rating(ratingReq.getRating(), ratingReq.getBookId(), ratingReq.getUsername());
            ratingRepository.save(rating);
            return new ApiResponse(0);
        }
        catch (Exception e){
            return new ApiResponse(1);
        }
    }
    @GetMapping("/{bookid}")
    public float getRating(@PathVariable String bookid){
        System.out.println("333");
        Long bookId = Long.parseLong(bookid);
        ArrayList<Rating> result = ratingRepository.findByBookId(bookId);
        if(result==null){
            return 0;
        }
        float sum = 0;
        int index =0;
        for(Rating i : result){
            sum+=i.getRating();
        }
        return sum/(result.size());
    }
}
