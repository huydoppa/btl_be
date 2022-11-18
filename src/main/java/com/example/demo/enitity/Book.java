package com.example.demo.enitity;

import javax.persistence.*;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private String date;
    @Column
    private Long numberOfPage;
    @Column
    private String linkImg;

    public Book(){}

    public Book(Long Id, String title, String author, String category, String date, Long numberOfPage,String linkImg,String description) {
        this.Id = Id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.date = date;
        this.numberOfPage = numberOfPage;
        this.linkImg = linkImg;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
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

    public Long getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Long numberOfPage) {
        this.numberOfPage = numberOfPage;
    }
}
