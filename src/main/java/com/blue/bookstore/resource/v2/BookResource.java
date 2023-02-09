/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blue.bookstore.resource.v2;

import com.blue.bookstore.dto.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12345
 */
@Path("v2/books")
public class BookResource {

    private List<Book> list = new ArrayList();

    public BookResource() {
        list.add(new Book("12346", "a", "blue", 1, 2022));
        list.add(new Book("12347", "a", "blue", 1, 2022));
        list.add(new Book("12348", "a", "blue", 1, 2022));
        list.add(new Book("12349", "a", "blue", 1, 2022));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        return list;
    }

    @GET
    //path param
    @Path("{book_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getOne(@PathParam("book_id") String isbn) {
        for (Book book : list)
            if (book.getIsbn().equals(isbn))
                return book;
        return null;
    }

}
