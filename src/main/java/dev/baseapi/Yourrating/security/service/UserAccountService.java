package dev.baseapi.Yourrating.security.service;

import dev.baseapi.Yourrating.security.model.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);

    Optional<UserAccount> findUserByUsername(String username);
}
