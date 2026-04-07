package org.jztrmnkl.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;
import org.jztrmnkl.repository.BookContainer;
import org.jztrmnkl.repository.BorrowingContainer;
import org.jztrmnkl.repository.LibraryRepository;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class LibraryServiceTest {
    private LibraryService libraryService = new LibraryService();

    @BeforeAll
    public static void setup(){
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book(1, "Kék"));
        booksList.add(new Book(2, "Zöld"));
        booksList.add(new Book(3, "Piros"));

        List<Borrowing> borrowingList = new ArrayList<>();
        borrowingList.add(new Borrowing(1,1));
        borrowingList.add(new Borrowing(1,3));

        LibraryRepository libraryRepositoryMock = Mockito.mock(LibraryRepository.class);
        BookContainer bookContainerMock = Mockito.mock(BookContainer.class);
        BorrowingContainer borrowingContainerMock = Mockito.mock(BorrowingContainer.class);

        when(libraryRepositoryMock.getBookContainer()).thenReturn(bookContainerMock);
        when(bookContainerMock.getBooks()).thenReturn(booksList);

        when(libraryRepositoryMock.getBorrowingContainer()).thenReturn(borrowingContainerMock);
        when(borrowingContainerMock.getBorrowings()).thenReturn(borrowingList);
    }

    @Test
    public void getBorrowedBooksTest(){
        List<Book> expected = new ArrayList<>();
        expected.add(new Book(1, "Kék"));
        expected.add(new Book(3, "Piros"));

        Borrower borrowerMock = Mockito.mock(Borrower.class);
        when(borrowerMock.getId()).thenReturn(1);

        Assertions.assertEquals(expected, libraryService.getBorrowedBooks(borrowerMock));
    }

}
