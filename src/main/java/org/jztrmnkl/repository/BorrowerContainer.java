package org.jztrmnkl.repository;

import org.jztrmnkl.entities.Borrower;

import java.util.ArrayList;
import java.util.List;

public class BorrowerContainer {
    private List<Borrower> borrowers;

    public BorrowerContainer(){
        borrowers = new ArrayList<>();
    }

    public List<Borrower> getBorrowers() {return borrowers;}
}
