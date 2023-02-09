/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blue.bookstore.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


/**
 *
 * @author 12345
 */
// using api:   localhost:6969/bookstore/api
@ApplicationPath("api")
public class BookApplication extends ResourceConfig {

    // main method of API
    public BookApplication() {
        packages("com.blue.bookstore.resource");
    }
}
