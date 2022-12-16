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
    public ApiResponse createBook(@ModelAttribute BookDTO bookdto
    ){
        if(bookService.checkExistBook(bookdto.getTitle())||bookdto.getTitle().equals("")||bookdto.getAuthor().equals("")){
            return new ApiResponse(1);
        }
        String linkImg = "";
        MultipartFile file = bookdto.getFile();
        System.out.println(file);
        if(file!=null){
        linkImg = fileStorageService.storeFile(file);
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(bookdto.getTitle());
        bookDTO.setAuthor(bookdto.getAuthor());
        bookDTO.setDate(bookdto.getDate());
        bookDTO.setDescription(bookdto.getDescription());
        bookDTO.setNumberofPage(bookdto.getNumberofPage());
        bookDTO.setLinkImg(linkImg);
        bookDTO.setCategory(bookdto.getCategory());
        return bookService.create(bookDTO);
    }
    @PostMapping("/update/{id}")
    public ApiResponse updatebook(@PathVariable String id ,BookDTO bookdto ) {
        if(bookService.checkExistBook(bookdto.getTitle())||bookdto.getTitle().equals("")||bookdto.getAuthor().equals("")){
            return new ApiResponse(1);
        }
        String linkImg = "";
        MultipartFile file = bookdto.getFile();
        if(file!=null){
            linkImg = fileStorageService.storeFile(file);
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(Long.parseLong(id));
        bookDTO.setTitle(bookdto.getTitle());
        bookDTO.setAuthor(bookdto.getAuthor());
        bookDTO.setDate(bookdto.getDate());
        bookDTO.setDescription(bookdto.getDescription());
        bookDTO.setNumberofPage(bookdto.getNumberofPage());
        bookDTO.setLinkImg(linkImg);
        bookDTO.setCategory(bookdto.getCategory());
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

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable String id) {
        return bookService.delete(id);
    }




}
