package org.jztrmnkl.repository;

import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryRepository {
    private List<Book> books;
    private List<Borrower> borrowers;

    public LibraryRepository(){
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    public List<Book> getBooks() {return books;}

    public List<Borrower> getBorrowers() {return borrowers;}
}
