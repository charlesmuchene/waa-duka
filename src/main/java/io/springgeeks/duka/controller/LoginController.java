package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Credentials;
import io.springgeeks.duka.domain.SystemUser;
import io.springgeeks.duka.service.CredentialServices;
import io.springgeeks.duka.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    CredentialServices credentialServices;

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginindex(@ModelAttribute("credentials") Credentials credentials) {

        return "login";
    }

    @RequestMapping(value = "/postlogin", method = RequestMethod.POST)
    public String login(@ModelAttribute("credentials") Credentials credentials) {
        String usn = credentials.getUsername();

        return "login";
    }


    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {

        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {

        return "redirect:/welcome";
    }
}
