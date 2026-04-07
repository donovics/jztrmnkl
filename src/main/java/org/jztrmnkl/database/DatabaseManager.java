package org.jztrmnkl.database;

import org.jztrmnkl.entities.Book;
import org.jztrmnkl.entities.Borrower;
import org.jztrmnkl.entities.Borrowing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String url = "jdbc:sqlite:storage.db";

    public static void connect(){
        String sqlCreateBookTable = "CREATE TABLE IF NOT EXISTS bookTable (\n" +
                "id INTEGER PRIMARY KEY,\n" +
                "name TEXT\n" +
                ");";
        String sqlCreateBorrowerTable = "CREATE TABLE IF NOT EXISTS borrowerTable (\n" +
                "id INTEGER PRIMARY KEY,\n" +
                "name TEXT,\n" +
                "age INTEGER\n" +
                ");";
        String sqlCreateBorrowingTable = "CREATE TABLE IF NOT EXISTS borrowingTable (\n" +
                "bookId INTEGER,\n" +
                "borrowerId INTEGER\n" +
                ");";


        try(Connection con = DriverManager.getConnection(url)){
            Statement stmt = con.createStatement();
            stmt.execute(sqlCreateBookTable);
            stmt.execute(sqlCreateBorrowerTable);
            stmt.execute(sqlCreateBorrowingTable);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertBook(Book book){
        String sqlInsert = "INSERT INTO bookTable(id, name) values(?, ?)";

        try(Connection con = DriverManager.getConnection(url)){
            PreparedStatement pstmt = con.prepareStatement(sqlInsert);
            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getName());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertBorrower(Borrower borrower){
        String sqlInsert = "INSERT INTO borrowerTable(id, name, age) values(?, ?, ?)";

        try(Connection con = DriverManager.getConnection(url)){
            PreparedStatement pstmt = con.prepareStatement(sqlInsert);
            pstmt.setInt(1, borrower.getId());
            pstmt.setString(2, borrower.getName());
            pstmt.setInt(3, borrower.getAge());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertBorrowing(Borrowing borrowing){
        String sqlInsert = "INSERT INTO borrowingTable(bookId, borrowerId) values(?, ?)";

        try(Connection con = DriverManager.getConnection(url)){
            PreparedStatement pstmt = con.prepareStatement(sqlInsert);
            pstmt.setInt(1, borrowing.getBookId());
            pstmt.setInt(2, borrowing.getBorrowerId());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Book> selectBooks(){
        String sqlSelect = "SELECT id, name FROM bookTable";
        List<Book> result = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(sqlSelect)){

            while (resultSet.next()){
                result.add(new Book(resultSet.getInt("id"), resultSet.getString("name")));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static List<Borrower> selectBorrowers(){
        String sqlSelect = "SELECT id, name, age FROM borrowerTable";
        List<Borrower> result = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(sqlSelect)){

            while (resultSet.next()){
                result.add(new Borrower(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age")));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static List<Borrowing> selectBorrowings(){
        String sqlSelect = "SELECT bookId, borrowerId FROM borrowingTable";
        List<Borrowing> result = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(sqlSelect)){

            while (resultSet.next()){
                result.add(new Borrowing(resultSet.getInt("bookId"), resultSet.getInt("borrowerId")));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return result;
    }
}
