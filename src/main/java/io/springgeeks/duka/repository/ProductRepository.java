package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "select p from Product p where activity = 'Renting'")
    public List<Product> findAllRentingProducts();

}
