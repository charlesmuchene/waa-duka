package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.SystemUser;
import io.springgeeks.duka.domain.User;
import io.springgeeks.duka.repository.UserRepository;
import io.springgeeks.duka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserService  {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User auser) {
        userRepository.save(auser);

    }

    @Override
    public List<User> listUsers() {
        List<User> us = (List<User>) userRepository.findAll();
        return us;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void removeUser(Long id) {

    }


}
