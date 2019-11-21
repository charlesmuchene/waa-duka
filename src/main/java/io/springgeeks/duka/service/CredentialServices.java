package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Credentials;

import java.util.List;

public interface CredentialServices {

        public void addCredentials(Credentials acred);
        public void updateCredentials(String password ,  String verifyPassword,  String username);
//        public List<Credentials> listCredentials();
        public Credentials getCredentialsByUserName(String userName);
//        public void removeCredentials(Long id);

}
