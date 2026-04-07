package org.jztrmnkl.service;

import org.jztrmnkl.database.DatabaseManager;
import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;
import org.jztrmnkl.repository.BookContainer;
import org.jztrmnkl.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    public LibraryService(){
        libraryRepository = new LibraryRepository();
        DatabaseManager.connect();

        List<Book> books =  DatabaseManager.selectBooks();
        for(Book b : books){
            libraryRepository.addBook(b);
        }

        List<Borrower> borrowers =  DatabaseManager.selectBorrowers();
        for(Borrower b : borrowers){
            libraryRepository.addBorrower(b);
        }

        List<Borrowing> borrowings =  DatabaseManager.selectBorrowings();
        for(Borrowing b : borrowings){
            libraryRepository.addBorrowing(b);
        }
    }

    public BookContainer getBooks(){
        return libraryRepository.getBookContainer();
    }

    public void addBook(Book book){
        if (!(libraryRepository.getBookContainer().getBooks().contains(book))){
            libraryRepository.addBook(book);
            DatabaseManager.insertBook(book);
        }
    }

    public void addBorrowing(Borrowing borrowing){
        boolean alreadyPresent = false;
        for (Borrowing b : libraryRepository.getBorrowingContainer().getBorrowings()){
            if (b.getBookId() == borrowing.getBookId()){
                alreadyPresent = true;
            }
        }

        if (!alreadyPresent) {
            libraryRepository.addBorrowing(borrowing);
            DatabaseManager.insertBorrowing(borrowing);
        }
    }

    public List<Borrowing> getBorrowings(){
        return libraryRepository.getBorrowingContainer().getBorrowings();
    }

    public void addBorrower(Borrower borrower){
        if (!(libraryRepository.getBorrowerContainer().getBorrowers().contains(borrower))){
            libraryRepository.addBorrower(borrower);
            DatabaseManager.insertBorrower(borrower);
        }
    }

    public Borrower getBorrower(Borrower borrower){
        Borrower foundBorrower = null;
        for (Borrower b : libraryRepository.getBorrowerContainer().getBorrowers()){
            if (b.getId() == borrower.getId()){
                foundBorrower = b;
            }
        }
        return foundBorrower;
    }

    public List<Book> getBorrowedBooks(Borrower borrower){
        List<Integer> borrowedBookIds = new ArrayList<>();
        for (Borrowing b : libraryRepository.getBorrowingContainer().getBorrowings()){
            if (b.getBorrowerId() == borrower.getId()) {
                borrowedBookIds.add(b.getBookId());
            }
        }

        List<Book> borrowedBooks = new ArrayList<>();
        int index = 0;
        for (Book b : libraryRepository.getBookContainer().getBooks()){
            if (index < borrowedBookIds.size()){
                if (b.getId() == borrowedBookIds.get(index)) {
                    borrowedBooks.add(b);
                    index++;
                }
            }
        }

        return borrowedBooks;
    }
}
