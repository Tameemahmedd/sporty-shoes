package com.sportyshoes.sportyshoes.controller;


import com.sportyshoes.sportyshoes.db.DB;
import com.sportyshoes.sportyshoes.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    DB db = DB.getInstance();

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return this.db.usersList;
    }
}
