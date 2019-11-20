package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.repository.BorrowingRepository;
import io.springgeeks.duka.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;

    @Override
    public boolean checkIfProductIsAvailableForBorrowing(LocalDate borrowedDate, LocalDate returnDate) {
        return borrowingRepository.checkAvailability(borrowedDate, returnDate);
    }
}
