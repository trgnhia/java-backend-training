package org.example.demo_spring.controller;

import org.example.demo_spring.model.Product;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    Product product = new Product("Nuoc ngot", 9500.0);



}
