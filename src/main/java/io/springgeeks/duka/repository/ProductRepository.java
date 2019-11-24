package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public Product findByNumber(String productNumber);

    @Query("SELECT p FROM Product p  WHERE p.name like :search%")
    List<Product> searchResults(@Param("search") String search);

    @Query("SELECT p FROM Product p where p.category = :category_id")
    List<Product> findProductByCategoryId(@Param("category_id") Long category_id);

}
