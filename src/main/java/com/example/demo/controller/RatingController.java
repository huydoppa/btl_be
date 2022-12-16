package com.example.demo.controller;

import com.example.demo.enitity.Rating;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.RatingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/rate")
public class RatingController {
    RatingRepository ratingRepository;

    @PostMapping("/create")
    public ApiResponse create(@RequestBody Rating ratingReq){
        try {
            Rating rating = new Rating(ratingReq.getRating(), ratingReq.getBook_id(), ratingReq.getUsername());
            ratingRepository.save(rating);
            return new ApiResponse(0);
        }
        catch (Exception e){
            return new ApiResponse(1);
        }
    }
    @GetMapping("/{bookid}")
    public float getRating(@PathVariable String bookId){
        Long bookid = Long.parseLong(bookId);
        ArrayList<Rating> result = ratingRepository.findByBookId(bookid);
        float sum = 0;
        int index =0;
        for(Rating i : result){
            sum+=i.getRating();
        }
        return sum/(result.size());
    }
}
