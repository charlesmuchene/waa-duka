package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.SystemUser;
import io.springgeeks.duka.repository.SystemUserRepository;
import io.springgeeks.duka.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemUserServiceImpl  implements SystemUserService {

    @Autowired
    private SystemUserRepository systemUserRepository;
    @Override
    public SystemUser addNewSystemUser(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }
}
