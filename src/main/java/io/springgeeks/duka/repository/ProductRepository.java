package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
    @Query("SELECT p FROM Product p  WHERE p.number like :search% or p.name like :search% or p.description like :search%")
    List<Product> searchResults(@Param("search") String search);
}
