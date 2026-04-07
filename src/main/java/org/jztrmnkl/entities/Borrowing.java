package org.jztrmnkl.entities;

public class Borrowing {
    private int bookId;
    private int borrowerId;

    public Borrowing(){}
    public Borrowing(int bookId, int borrowerId){
        this.bookId = bookId;
        this.borrowerId = borrowerId;
    }

    public int getBookId() {return bookId;}
    public int getBorrowerId() {return borrowerId;}
}
