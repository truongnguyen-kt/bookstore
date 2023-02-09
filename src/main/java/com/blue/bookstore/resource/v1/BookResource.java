/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blue.bookstore.resource.v1;

import com.blue.bookstore.dto.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author 12345
 */
@Path("v1/books")
// using: localhost:6969/bookstore/api/v1/books
public class BookResource {
    
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String sayHello(){
//        return "One small message return from my own first API, one giant leap for IT knowledge!!";
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(){
        return new Book("12345", "Toi Thay hoa vang tren co xanh", "Nguyen Nhat Anh", 1, 2017);
    }
}
