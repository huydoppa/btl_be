package com.example.demo.controller;

import com.example.demo.dtos.BookDTO;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.BookResponse;
import com.example.demo.repository.BookRepository;
import com.example.demo.serivce.BookService;
import com.example.demo.serivce.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FileStorageService fileStorageService;



    @RequestMapping(path = "/create", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ApiResponse createBook(@RequestPart MultipartFile file, @RequestParam String title, @RequestParam String author ,
                                  @RequestParam String date, @RequestParam String category, @RequestParam String numberofPage,
                                  @RequestParam String description
    ){
        String linkImg = "";
        if(file!=null){
        linkImg = fileStorageService.storeFile(file);
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(title);
        bookDTO.setAuthor(author);
        bookDTO.setDate(date);
        bookDTO.setDescription(description);
        bookDTO.setNumberofPage(Long.parseLong(numberofPage));
        bookDTO.setLinkImg(linkImg);
        bookDTO.setCategory(category);
        return bookService.create(bookDTO);
    }
    @PostMapping("/update/{id}")
    public ApiResponse updatebook(@PathVariable String id ,@RequestPart(required = false) MultipartFile file, @RequestParam String title, @RequestParam String author ,
                                  @RequestParam String date, @RequestParam String category, @RequestParam String numberofPage,
                                  @RequestParam String description) {
        String linkImg = "";
        if(file!=null){
        linkImg = fileStorageService.storeFile(file);}
        System.out.println("=========================="+linkImg);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(Long.parseLong(id));
        bookDTO.setTitle(title);
        bookDTO.setAuthor(author);
        bookDTO.setDate(date);
        bookDTO.setDescription(description);
        bookDTO.setNumberofPage(Long.parseLong(numberofPage));
        bookDTO.setLinkImg(linkImg);
        bookDTO.setCategory(category);
        return bookService.update(bookDTO);
    }

    @GetMapping
    public BookResponse getAllbook(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BookResponse getBook(@PathVariable String id)
    {
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable String id) {
        return bookService.delete(id);
    }



}
