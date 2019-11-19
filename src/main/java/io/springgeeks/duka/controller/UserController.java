package io.springgeeks.duka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public String users() {
        throw new IllegalStateException("Implement this");
    }

    @GetMapping("add")
    public String getAddUserForm() {
        throw new IllegalStateException("Implement this");
    }
}
