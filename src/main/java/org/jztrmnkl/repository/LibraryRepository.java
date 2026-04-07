package org.jztrmnkl.repository;

import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibraryRepository {

    private static BookContainer bookContainer = new BookContainer();
    private static BorrowerContainer borrowerContainer = new BorrowerContainer();
    private static BorrowingContainer borrowingContainer = new BorrowingContainer();

    public BookContainer getBookContainer() {return bookContainer;}
    public BorrowerContainer getBorrowerContainer() {return borrowerContainer;}
    public BorrowingContainer getBorrowingContainer() {return borrowingContainer;}

    public void addBook(Book book){
        bookContainer.getBooks().add(book);
    }
    public void addBorrower(Borrower borrower){
        borrowerContainer.getBorrowers().add(borrower);
    }
    public void addBorrowing(Borrowing borrowing){
        borrowingContainer.getBorrowings().add(borrowing);
    }
}
