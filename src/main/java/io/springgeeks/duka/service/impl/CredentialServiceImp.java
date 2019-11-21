package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Credentials;
import io.springgeeks.duka.repository.CredentialsRepository;
import io.springgeeks.duka.service.CredentialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CredentialServiceImp implements CredentialServices {
    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public void addCredentials(Credentials acred) {
        credentialsRepository.save(acred);
    }

    @Override
    public void updateCredentials(String password, String verifyPassword, String username) {
        credentialsRepository.updateCredentials(password,verifyPassword,username);

    }

    @Override
    public Credentials getCredentialsByUserName(String userName) {
        return credentialsRepository.findUserByUsername(userName);
    }
}
