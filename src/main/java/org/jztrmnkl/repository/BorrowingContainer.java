package org.jztrmnkl.repository;

import org.jztrmnkl.entities.Borrowing;

import java.util.ArrayList;
import java.util.List;

public class BorrowingContainer {
    private List<Borrowing> borrowings;

    public BorrowingContainer(){
        borrowings = new ArrayList<>();

    }

    public List<Borrowing> getBorrowings() {return borrowings;}
}
