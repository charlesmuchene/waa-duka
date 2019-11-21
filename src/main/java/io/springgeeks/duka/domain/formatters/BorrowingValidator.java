package io.springgeeks.duka.domain.formatters;

import io.springgeeks.duka.domain.Borrowing;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BorrowingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == Borrowing.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowedDate", "Borrowed date is required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "returnDate", "Return date is required!");
        Borrowing borrowing = (Borrowing) o;
        if(borrowing.getBorrowedDate() != null && borrowing.getReturnDate().isBefore(LocalDateTime.now())) {
            errors.rejectValue("borrowedDate", "Borrowed date cannot be in the past!");
        }
        if(borrowing.getReturnDate() != null && !borrowing.getReturnDate().isBefore(LocalDateTime.now())) {
            errors.rejectValue("returnDate", "Return date must be in the past!");
        }
        if(!borrowing.getBorrowedDate().isBefore(borrowing.getReturnDate())) {
            errors.rejectValue("returnDate", "Return date must be after Borrowed date!");
        }
    }
}
