package dev.baseapi.Yourrating.security.service;

import dev.baseapi.Yourrating.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
