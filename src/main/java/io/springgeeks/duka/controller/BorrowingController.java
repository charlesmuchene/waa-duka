package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Borrowing;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.domain.SystemUser;
import io.springgeeks.duka.domain.formatters.ProductNotAvailableException;
import io.springgeeks.duka.service.BorrowingService;
import io.springgeeks.duka.service.ProductService;
import io.springgeeks.duka.util.LocalDatePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/borrow")
@SessionAttributes(value = {"productToRent"})
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{selectedProductId}", method = RequestMethod.GET)
    public String borrowForm(@PathVariable String selectedProductId,
                             @ModelAttribute("newBorrow") Borrowing borrowing,
                             Model model) {
        Product product = productService.findByProductSerialNumber(selectedProductId);
        if (product != null) {
            model.addAttribute("productToRent", product);
            return "borrow";
        }
        return "welcome";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Borrowing borrow(@Valid @RequestBody Borrowing borrowing, HttpServletRequest request) throws ProductNotAvailableException {
        Product product = (Product) request.getSession(true).getAttribute("productToRent");
        if (!borrowingService.checkIfProductIsAvailableForBorrowing(borrowing.getBorrowedDate(), borrowing.getReturnDate(), product)) {
            throw new ProductNotAvailableException();
        } else {
            borrowing.setProduct(product);
            SystemUser systemUser = new SystemUser();
            systemUser.setId(1);
            borrowing.setSystemUser(systemUser);
            borrowing = borrowingService.save(borrowing);
        }
        return borrowing;

    }

    @RequestMapping(value = "/availability", method = RequestMethod.GET)
    public @ResponseBody
    List<LocalDatePair> checkProductRentAvailability(@RequestParam("startDate") String startDateStr, @RequestParam("endDate") String endDateStr,
                                                     HttpServletRequest request) {
        List<LocalDatePair> slots = new ArrayList<>();
        try {
            Product product = (Product) request.getSession(true).getAttribute("productToRent");
            slots = borrowingService.availableSpots(LocalDateTime.parse(startDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")), LocalDateTime.parse(endDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")), product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slots;
    }
}
