package io.springgeeks.duka.domain.formatters;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductNotAvailableException extends RuntimeException {

    private String exceptionMessage = "Product not found";

    public ProductNotAvailableException() {

    }

    @Override
    public String getMessage() {
        return exceptionMessage;
    }
}
