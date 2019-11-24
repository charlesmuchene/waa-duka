package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Borrowing;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.repository.BorrowingRepository;
import io.springgeeks.duka.service.BorrowingService;
import io.springgeeks.duka.util.LocalDatePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Override
    public boolean checkIfProductIsAvailableForBorrowing(LocalDateTime borrowedDate, LocalDateTime returnDate, Product product) {
        List<Borrowing>list = borrowingInTheSelectedRange(borrowedDate, returnDate, borrowingRepository.findByProduct(product));
        return list.size() == 0;
    }

    @Override
    public List<LocalDatePair> availableSpots(LocalDateTime startDate, LocalDateTime endDate, Product product) {
        List<Borrowing> sortedList = borrowingInTheSelectedRange(startDate, endDate, borrowingRepository.findByProduct(product));
        List<LocalDatePair> slots = new ArrayList<>();

        if (sortedList != null && sortedList.size() > 0) {
            for (int i = 0; i < sortedList.size(); i++) {
                LocalDatePair pair = new LocalDatePair();
                if (i == 0 && startDate.isBefore(sortedList.get(i).getBorrowedDate())) {
                    pair.setStartDate(startDate);
                    pair.setEndDate(sortedList.get(i).getBorrowedDate());
                    slots.add(pair);
                } else if ((i + 1) != sortedList.size() && sortedList.get(i).getReturnDate().until(sortedList.get(i + 1).getBorrowedDate(), ChronoUnit.MINUTES) > 0) {
                    pair.setStartDate(sortedList.get(i).getReturnDate());
                    pair.setEndDate((sortedList.get(i + 1).getBorrowedDate()));
                    slots.add(pair);
                }
                if ((i + 1) == sortedList.size() && sortedList.get(i).getReturnDate().until(endDate, ChronoUnit.MINUTES) > 0) {
                    pair.setStartDate(sortedList.get(i).getReturnDate());
                    pair.setEndDate(endDate);
                    slots.add(pair);
                }
            }
        } else {
            LocalDatePair pair = new LocalDatePair();
            pair.setStartDate(startDate);
            pair.setEndDate(endDate);
            slots.add(pair);
        }
        return slots;
    }

    @Override
    public List<Borrowing> borrowingInTheSelectedRange(LocalDateTime startDate, LocalDateTime endDate, List<Borrowing> list) {
        return list.stream().sorted(Comparator.comparing(Borrowing::getBorrowedDate).thenComparing(Borrowing::getReturnDate))
                .filter(b -> (!b.getBorrowedDate().isBefore(startDate) && b.getBorrowedDate().isBefore(endDate)) ||
                        (b.getReturnDate().isAfter(startDate) && !b.getReturnDate().isAfter(endDate)))
                .collect(Collectors.toList());
    }

    @Override
    public Borrowing save(Borrowing borrowing) {
        try {
            return borrowingRepository.save(borrowing);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
