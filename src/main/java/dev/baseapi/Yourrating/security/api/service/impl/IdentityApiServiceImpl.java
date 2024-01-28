package dev.baseapi.Yourrating.security.api.service.impl;

import dev.baseapi.Yourrating.security.api.model.CurrentUserApiModel;
import dev.baseapi.Yourrating.security.api.service.IdentityApiService;
import dev.baseapi.Yourrating.security.model.UserAccount;
import dev.baseapi.Yourrating.security.service.UserAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityApiServiceImpl implements IdentityApiService {

    private final UserAccountService userAccountService;

    public IdentityApiServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null) {
            return Optional.empty();
        }
        String userName = authentication.getName();

        return extractCurrentUserApiModel(userName);
    }

    private Optional<CurrentUserApiModel> extractCurrentUserApiModel(String username) {
        return this.userAccountService.findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }
}
