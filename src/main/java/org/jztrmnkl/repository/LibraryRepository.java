package org.jztrmnkl.repository;

import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryRepository {
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<Borrowing> borrowings;

    public LibraryRepository(){
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
        borrowings = new ArrayList<>();
    }

    public List<Book> getBooks() {return books;}
    public List<Borrower> getBorrowers() {return borrowers;}
    public List<Borrowing> getBorrowings() {return borrowings;}

    public void addBook(Book book){
        books.add(book);
    }
    public void addBorrower(Borrower borrower){
        borrowers.add(borrower);
    }
    public void addBorrowing(Borrowing borrowing){
        borrowings.add(borrowing);
    }
}
