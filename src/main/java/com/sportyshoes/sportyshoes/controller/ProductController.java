package com.sportyshoes.sportyshoes.controller;

import com.sportyshoes.sportyshoes.db.DB;
import com.sportyshoes.sportyshoes.model.Shoe;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    DB db = DB.getInstance();

    @GetMapping("/getAllProducts")
    public List<Shoe> getAllProducts() {
        return this.db.shoesList;
    }
}
