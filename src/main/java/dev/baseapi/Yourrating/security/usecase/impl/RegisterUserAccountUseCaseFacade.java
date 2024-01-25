package dev.baseapi.Yourrating.security.usecase.impl;

import dev.baseapi.Yourrating.security.mapper.RegisterRequestToUserAccountMapper;
import dev.baseapi.Yourrating.security.model.UserAccount;
import dev.baseapi.Yourrating.security.service.UserAccountService;
import dev.baseapi.Yourrating.security.usecase.RegisterUserAccountUseCase;
import dev.baseapi.Yourrating.security.web.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;

    public RegisterUserAccountUseCaseFacade(UserAccountService userAccountService, RegisterRequestToUserAccountMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = this.mapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }
}
