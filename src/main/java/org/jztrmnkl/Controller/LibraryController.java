package org.jztrmnkl.Controller;

import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;
import org.jztrmnkl.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/Library")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @GetMapping("/Books")
    public List<Book> getBooks(){
        return libraryService.getBooks();
    }

    @PostMapping("/Books")
    public void postBook(@RequestBody Book book){
        libraryService.addBook(book);
    }

    @PostMapping("/Borrowing")
    public void postBorrowing(@RequestBody Borrowing borrowing){
        libraryService.addBorrowing(borrowing);
    }

    @PostMapping("/Borrower")
    public void postBorrower(@RequestBody Borrower borrower){
        libraryService.addBorrower(borrower);
    }

    @GetMapping("/Borrower")
    public Borrower getBorrower(int id, String name){
        return libraryService.getBorrower(id, name);
    }

    @GetMapping("/Borrowing")
    public List<Book> getBorrowedBooks(int id, String name){
        return libraryService.getBorrowedBooks(id, name);
    }

}
