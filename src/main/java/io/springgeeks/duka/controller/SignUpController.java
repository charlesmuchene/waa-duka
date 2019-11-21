package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.domain.SystemUser;
import io.springgeeks.duka.service.BiddingService;
import io.springgeeks.duka.service.ProductService;
import io.springgeeks.duka.service.SystemUserService;
import io.springgeeks.duka.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SignUpController {
    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping(value = "/postSignUp", method = RequestMethod.POST)
    public String processAddNewEmployee(@Valid @ModelAttribute("newParticipant") SystemUser systemUser, BindingResult bindingResult, Model model ) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        SystemUser su = systemUserService.addNewSystemUser(systemUser);
        //redirectAttributes.addFlashAttribute("ewParticipant",su);
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/signup")
    public String mysignup(@ModelAttribute("newParticipant") SystemUser systemUser){
        return "signup";
    }

}
