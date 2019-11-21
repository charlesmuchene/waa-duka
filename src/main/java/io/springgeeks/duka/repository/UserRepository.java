package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User  u where u.id= :id")
    public  User findUserById(@Param("id") long id) ;


}
