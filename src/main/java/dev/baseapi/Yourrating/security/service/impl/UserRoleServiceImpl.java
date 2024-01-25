package dev.baseapi.Yourrating.security.service.impl;

import dev.baseapi.Yourrating.security.model.UserRole;
import dev.baseapi.Yourrating.security.repository.UserRoleRepository;
import dev.baseapi.Yourrating.security.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Optional<UserRole> findUserRole() {
        return this.userRoleRepository.findByAuthority("ROLE_USER");
    }
}
