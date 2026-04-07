package org.jztrmnkl.repository;

import org.jztrmnkl.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookContainer {
    private List<Book> books;

    public BookContainer(){
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {return books;}
}
