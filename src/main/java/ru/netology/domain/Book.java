package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;
//    private int pages;
//    private int publishedYear;


    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}
