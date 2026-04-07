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

    }

    @PostMapping("/Books")
    public void postBook(@RequestBody Book book){

    }

    @PostMapping("/Borrowing")
    public void postBorrowing(@RequestBody Borrowing borrowing){

    }

    @PostMapping("/Borrower")
    public void postBorrower(@RequestBody Borrower borrower){

    }

    @GetMapping("/Borrower")
    public Borrower getBorrower(){

    }

    @GetMapping("/Borrowing")
    public List<Book> getBorrowing(){

    }

}
