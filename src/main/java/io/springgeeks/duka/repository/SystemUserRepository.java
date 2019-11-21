package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

}
