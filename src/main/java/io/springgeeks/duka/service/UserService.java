package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.SystemUser;
import io.springgeeks.duka.domain.User;


import java.util.List;

public interface UserService  {
    public void addUser(User auser);
    public List<User> listUsers();
    public User getUserById(Long id);
    public void removeUser(Long id);


}
