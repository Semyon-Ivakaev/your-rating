package dev.baseapi.Yourrating.security.repository;

import dev.baseapi.Yourrating.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByAuthority(String authority);
}
