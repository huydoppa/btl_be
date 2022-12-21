package com.example.demo.serivce;

import com.example.demo.dtos.BookDTO;
import com.example.demo.enitity.Book;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.BookResponse;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public BookResponse getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setCategory(book.getCategory());
            bookDTO.setDate(book.getDate());
            bookDTO.setNumberofPage(book.getNumberOfPage());
            bookDTO.setLinkImg(book.getLinkImg());
            bookDTO.setDescription(book.getDescription());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return new BookResponse(bookDTOS);
    }

    public BookResponse getBook(String id) {
        Book Book = bookRepository.getById(Long.parseLong(id));
        BookDTO BookDTOs = new BookDTO();
        if(Book!=null) {
            BookDTOs.setTitle(Book.getTitle());
            BookDTOs.setId(Book.getId());
            BookDTOs.setAuthor(Book.getAuthor());
            BookDTOs.setCategory(Book.getCategory());
            BookDTOs.setDescription(Book.getDescription());
            BookDTOs.setDate(Book.getDate());
            BookDTOs.setLinkImg(Book.getLinkImg());
            BookDTOs.setPrice(Book.getPrice());
            BookDTOs.setNumberofPage(Book.getNumberOfPage());
        }
            return new BookResponse(BookDTOs);

    }
    public ApiResponse create(BookDTO BookDTO) {
        Book Book = new Book();
        Book.setTitle(BookDTO.getTitle());
        Book.setAuthor(BookDTO.getAuthor());
        Book.setDate(BookDTO.getDate());
        Book.setDescription(BookDTO.getDescription());
        Book.setCategory(BookDTO.getCategory());
        Book.setLinkImg(BookDTO.getLinkImg());
        Book.setNumberOfPage(BookDTO.getNumberofPage());
        Book.setPrice(BookDTO.getPrice());
        bookRepository.save(Book);
        return new ApiResponse(0);
    }

    public ApiResponse update(BookDTO BookDTO) {
        Book Book = bookRepository.getById(BookDTO.getId());
        Book.setTitle(BookDTO.getTitle());
        Book.setAuthor(BookDTO.getAuthor());
        Book.setDate(BookDTO.getDate());
        Book.setDescription(BookDTO.getDescription());
        Book.setCategory(BookDTO.getCategory());
        Book.setLinkImg(BookDTO.getLinkImg());
        Book.setNumberOfPage(BookDTO.getNumberofPage());
        Book.setPrice(BookDTO.getPrice());
        bookRepository.save(Book);
        return new ApiResponse(0);
    }

    public ApiResponse delete(String id) {
        ApiResponse response = new ApiResponse();
        Book Book = bookRepository.getById(Long.parseLong(id));
        if (Objects.isNull(Book)) {
            response.setMsg("Khong tim thay san pham nay!");
        } else {
            bookRepository.deleteById(Long.parseLong(id));
        }
        return response;
    }

    public Boolean checkExistBook(String title){
        return bookRepository.existsByTitle(title);
    }

}