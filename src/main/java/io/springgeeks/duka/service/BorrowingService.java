package io.springgeeks.duka.service;

import java.time.LocalDate;

public interface BorrowingService {

    boolean checkIfProductIsAvailableForBorrowing(LocalDate borrowedDate, LocalDate returnDate);

}
