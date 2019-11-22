package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByNumber(String productNumber);
    Product findBySerialNumber(String serialNumber);

    @Query("SELECT p FROM Product p  WHERE p.name like :search%")
    List<Product> searchResults(@Param("search") String search);

}
