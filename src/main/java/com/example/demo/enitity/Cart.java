package com.example.demo.enitity;

import javax.persistence.*;

@Entity
@Table(name = "cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "book")
    private String book ;
    @Column(name="quantity")
    private Long quantity ;
    @Column(name = "user_id")
    private Long user_id;


    public Cart(){}

    public Cart( String book , Long quantity,Long user_id){
        this.book = book;
        this.quantity = quantity;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
