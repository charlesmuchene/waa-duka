package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BiddingRepository extends CrudRepository<Bid, Long> {
}
