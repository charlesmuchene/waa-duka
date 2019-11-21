package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.User;
import io.springgeeks.duka.service.CredentialServices;
import io.springgeeks.duka.service.UserService;

import io.springgeeks.duka.service.impl.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
   private UserService userService;
//    @Autowired
//    private CredentialServices credentialServicesnt;


    @GetMapping("/")
    public String users( Model model) {
        List<User> sysUsers = userService.listUsers();
        return "welcome";

        //throw new IllegalStateException("Implement this");
    }

    @GetMapping("/add")
    public String getAddUserForm(@ModelAttribute("user") User user) {
        return "signup";

      //  throw new IllegalStateException("Implement this");
    }
}
