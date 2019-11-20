package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Borrowing;
import io.springgeeks.duka.domain.formatters.LocalDateFormatter;
import io.springgeeks.duka.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/borrow")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @RequestMapping(method = RequestMethod.GET)
    public String borrowForm(@ModelAttribute("newBorrow")Borrowing borrowing) {
        return "borrow";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String borrow(@Valid @ModelAttribute("newBorrow") Borrowing borrowing, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            borrowingService.checkIfProductIsAvailableForBorrowing(borrowing.getBorrowedDate(), borrowing.getReturnDate());
            return "redirect:/welcome";
        }
        return "borrow";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new LocalDateFormatter("MM/dd/yyyy hh:mm"));
    }
}
