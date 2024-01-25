package dev.baseapi.Yourrating.security.repository;

import dev.baseapi.Yourrating.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    boolean existsByUsername(String username);
}
