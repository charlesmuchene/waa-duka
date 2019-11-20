package io.springgeeks.duka.service;

import java.time.LocalDate;

public interface BorrowingService {

    public boolean checkIfProductIsAvailableForBorrowing(LocalDate borrowedDate, LocalDate returnDate);

}
