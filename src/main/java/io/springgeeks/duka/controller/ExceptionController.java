package io.springgeeks.duka.controller;

import java.util.List;

import io.springgeeks.duka.domain.formatters.DomainError;
import io.springgeeks.duka.domain.formatters.DomainErrors;
import io.springgeeks.duka.domain.formatters.ProductNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {


    @Autowired
    MessageSourceAccessor messageAccessor;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DomainErrors handleException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        DomainErrors errors = new DomainErrors();
        errors.setErrorType("ValidationError");
        for (FieldError fieldError : fieldErrors) {
            System.out.println("################" + fieldError);
            DomainError error = new DomainError(messageAccessor.getMessage(fieldError));
            errors.addError(error);
        }

        return errors;
    }

    @ExceptionHandler(ProductNotAvailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    DomainErrors handleError(ProductNotAvailableException exception) {

        DomainErrors errors = new DomainErrors();
        errors.setErrorType("ProductException");
        errors.setMessage(exception.getMessage());
        return errors;
    }


}
