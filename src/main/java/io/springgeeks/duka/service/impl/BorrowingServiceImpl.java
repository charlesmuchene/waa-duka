package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.repository.BorrowingRepository;
import io.springgeeks.duka.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Override
    public boolean checkIfProductIsAvailableForBorrowing(LocalDate borrowedDate, LocalDate returnDate) {
        return borrowingRepository.checkAvailability(borrowedDate, returnDate);
    }
}
