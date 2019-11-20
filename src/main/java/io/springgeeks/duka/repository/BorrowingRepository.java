package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Borrowing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Integer> {

    @Query(value = "select d, case when (select count(b) from Borrowing b where " +
            "(b.borrowedDate < ':returnDate' and b.borrowedDate >= ':borrowedDate') or " +
            "(b.returnDate > ':borrowedDate' and b.returnDate <= ':returnDate'))" +
            "= 0 then true else false end from dual")
    public boolean checkAvailability(LocalDate borrowedDate, LocalDate returnDate);

}
