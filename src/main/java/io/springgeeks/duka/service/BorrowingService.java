package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Borrowing;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.util.LocalDatePair;
import java.time.LocalDateTime;
import java.util.List;

public interface BorrowingService {

    boolean checkIfProductIsAvailableForBorrowing(LocalDateTime borrowedDate, LocalDateTime returnDate);
    List<Borrowing> borrowingInTheSelectedRange(LocalDateTime startDate, LocalDateTime endDate, List<Borrowing>list);
    List<LocalDatePair> availableSpots(LocalDateTime startDate, LocalDateTime endDate, Product product);
    Borrowing save(Borrowing borrowing);

}
