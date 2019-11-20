package io.springgeeks.duka.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

    Authentication getAuthentication();

}
