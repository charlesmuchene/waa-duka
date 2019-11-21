package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Credentials;
import io.springgeeks.duka.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CredentialsRepository extends CrudRepository <Credentials, Long>{

    @Query( "update Credentials c set password =:p1, verifyPassword= :p2 where c.username = :username")
    void updateCredentials (@Param("p1") String password , @Param("p2") String verifyPassword, @Param("username") String username);

    @Query("select cr from Credentials  cr  where cr.username= :username")
    public Credentials findUserByUsername(@Param("username") String username) ;


}
