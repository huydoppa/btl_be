package com.example.demo.dtos;

import org.springframework.web.multipart.MultipartFile;

public class BookDTO {
    private Long Id;
    private String title;
    private String author;
    private String category;
    private String date;
    private Long numberofPage;
    private String linkImg;
    private String description;

    private MultipartFile file;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getNumberofPage() {
        return numberofPage;
    }

    public void setNumberofPage(Long numberofPage) {
        this.numberofPage = numberofPage;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
