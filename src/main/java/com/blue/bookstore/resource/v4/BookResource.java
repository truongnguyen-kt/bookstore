/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blue.bookstore.resource.v4;
import com.blue.bookstore.dao.BookDAO;
import com.blue.bookstore.dto.Book;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author 12345
 */
@Path("v4/books")
public class BookResource {

//    @POST
//    public void addNewBook(@RequestBody Book dto) {
//        BookDAO dao = BookDAO.getInstance();
////        System.out.println(dto);
//        dao.addOne(dto);
//    }
}
