package org.jztrmnkl.Controller;

import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;
import org.jztrmnkl.repository.BookContainer;
import org.jztrmnkl.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Library")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @GetMapping("/Books")
    public BookContainer getBooks(){
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
    public String getBorrower(@RequestBody Borrower borrower){
        Borrower foundBorrower = libraryService.getBorrower(borrower);
        String returnString = "Theres no identical entry in the database";
        if (foundBorrower != null) {
            returnString = "id: " + foundBorrower.getId() + "\nname: " + foundBorrower.getName() + "\nage: " + foundBorrower.getAge();
        }

        return returnString;
    }

    @GetMapping("/Borrowing")
    public String getBorrowedBooks(@RequestBody Borrower borrower){
        List<Book> foundBooks = libraryService.getBorrowedBooks(borrower);

        String returnString = "Theres no books borrowed by the person";
        if (!foundBooks.isEmpty()) {
            returnString = foundBooks.stream()
                    .map(Book::getName)
                    .collect(Collectors.joining(", "));
        }

        return returnString;
    }

}
