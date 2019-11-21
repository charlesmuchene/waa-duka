package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Borrowing;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.util.LocalDatePair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Integer> {

    @Query(value = "select count(b) from Borrowing b where " +
            "(b.borrowedDate < ?2 and b.borrowedDate >= ?1) or " +
            "(b.returnDate > ?1 and b.returnDate <= ?2)")
    int checkAvailability(LocalDateTime borrowedDate, LocalDateTime returnDate);

    List<Borrowing> findByProduct(Product product);

}
