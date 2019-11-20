package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Borrowing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Integer> {

    @Query(value = "select case when (select count(b) from Borrowing b where " +
            "(b.borrowedDate < ':returnDate' and b.borrowedDate >= ':borrowedDate') or " +
            "(b.returnDate > ':borrowedDate' and b.returnDate <= ':returnDate'))" +
            "= 0 then false else true end FROM Borrowing")
    public boolean checkAvailability(@Param("borrowedDate") LocalDate borrowedDate,
                                     @Param("returnDate") LocalDate returnDate);

}
