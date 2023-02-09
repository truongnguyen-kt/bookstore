/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blue.bookstore.resource.v3;

import com.blue.bookstore.dao.BookDAO;
import com.blue.bookstore.dto.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author 12345
 */
@Path("v3/books")
public class BookResource {
    private BookDAO dao = BookDAO.getInstance();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll(){
        return dao.getAll();
    }
    
    @GET
    //path param
    @Path("{book_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getOne(@PathParam("book_id") String isbn) {
        return dao.getOne(isbn);
    }
}
