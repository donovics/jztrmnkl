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
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryServiceTest {
    private LibraryService libraryService = new LibraryService();

    static LibraryRepository libraryRepositoryMock = Mockito.mock(LibraryRepository.class);
    static BookContainer bookContainerMock = Mockito.mock(BookContainer.class);
    static BorrowingContainer borrowingContainerMock = Mockito.mock(BorrowingContainer.class);

    static List<Book> booksList = new ArrayList<>();
    static List<Borrowing> borrowingList = new ArrayList<>();

    @BeforeAll
    public static void setUp(){

        booksList.add(new Book(1, "Kék"));
        booksList.add(new Book(2, "Zöld"));
        booksList.add(new Book(3, "Piros"));


        borrowingList.add(new Borrowing(1,1));
        borrowingList.add(new Borrowing(3,1));

        when(libraryRepositoryMock.getBookContainer()).thenReturn(bookContainerMock);
        when(bookContainerMock.getBooks()).thenReturn(booksList);

        when(libraryRepositoryMock.getBorrowingContainer()).thenReturn(borrowingContainerMock);
        when(borrowingContainerMock.getBorrowings()).thenReturn(borrowingList);

    }

    @Test
    public void getBorrowedBooksTest(){
        ReflectionTestUtils.setField(libraryService,"libraryRepository",libraryRepositoryMock);


        List<Book> expected = new ArrayList<>();
        expected.add(new Book(1, "Kék"));
        expected.add(new Book(3, "Piros"));

        Borrower borrowerMock = Mockito.mock(Borrower.class);
        when(borrowerMock.getId()).thenReturn(1);

        String expectedString = expected.stream().map(e -> e.getId() +", " + e.getName() ).collect(Collectors.joining("; "));
        List<Book> actual = libraryService.getBorrowedBooks(borrowerMock);
        String actualString = actual.stream().map(e -> e.getId() +", " + e.getName() ).collect(Collectors.joining("; "));
        Assertions.assertEquals(expectedString, actualString);

        verify(libraryRepositoryMock).getBorrowingContainer();
        verify(borrowingContainerMock).getBorrowings();

        verify(libraryRepositoryMock).getBookContainer();
        verify(bookContainerMock).getBooks();
    }

}
