/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blue.bookstore.dao;

import com.blue.bookstore.dto.Book;
import com.blue.bookstore.util.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12345
 */
public class BookDAO implements Serializable {

    private static BookDAO instance;
    private Connection conn = DBUtil.makeConnection();

    // Cấm new trực tiếp BookDAO
    //Chỉ new BookDAO qua hàm static getInstance() để quản lí được số object/instance đã new - SINGLETON DESIGN PATTERN
    private BookDAO() {
    }

    public static BookDAO getInstance() {

        if (instance == null) {
            instance = new BookDAO();
        }
        return instance;
    }

    // Lấy ra tất cả sách trong kho
    public List<Book> getAll() {

        PreparedStatement stm;
        ResultSet rs;

        List<Book> bookList = new ArrayList();
        try {

            String sql = "SELECT * FROM BOOK";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                bookList.add(new Book(rs.getString("Isbn"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Edition"),
                        rs.getInt("PublishedYear")));
            }
        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    // Lấy ra một cuốn sách dựa trên mã sách
    public Book getOne(String isbn) {

        PreparedStatement stm;
        ResultSet rs;

        try {

            String sql = "SELECT * FROM BOOK WHERE Isbn = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, isbn);

            rs = stm.executeQuery();
            if (rs.next()) {
                return new Book(rs.getString("Isbn"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Edition"),
                        rs.getInt("PublishedYear"));
            }

        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Lấy ra các cuốn sách của tác giả nào đó
    public List<Book> getAllByAuthor(String author) {

        PreparedStatement stm;
        ResultSet rs;

        List<Book> bookList = new ArrayList();

        try {

            String sql = "SELECT * FROM BOOK WHERE Author = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, author);

            rs = stm.executeQuery();
            while (rs.next()) {
                bookList.add(new Book(rs.getString("Isbn"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Edition"),
                        rs.getInt("PublishedYear")));
            }
            return bookList;

        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Book addOne(String isbn,  String title, String author, int edition, int publishedYear) {

        PreparedStatement stm;
        int rs;

        try {

            String sql = "INSERT INTO BOOK "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "? "
                    + ") ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, isbn);
            stm.setString(2, title);
            stm.setString(3, author);
            stm.setInt(4, edition);
            stm.setInt(5, publishedYear);

            rs = stm.executeUpdate();
            if (rs > 0) {
                return new Book(isbn, title, author, edition, publishedYear);
            }

        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Book addOne(Book dto) {

        PreparedStatement stm;
        int rs;

        try {

            String sql = "INSERT INTO BOOK "
                    + "VALUES ("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "? "
                    + ") ";
            String isbn = dto.getIsbn();
            String title = dto.getTitle();
            String author = dto.getAuthor();
            int edition = dto.getEdition();
            int publishedYear = dto.getPublishedYear();
            stm = conn.prepareStatement(sql);
            stm.setString(1, isbn);
            stm.setString(2, title);
            stm.setString(3, author);
            stm.setInt(4, edition);
            stm.setInt(5, publishedYear);

            rs = stm.executeUpdate();
            if (rs > 0) {
                return new Book(isbn, title, author, edition, publishedYear);
            }

        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(getInstance().getAll());
    }
}
