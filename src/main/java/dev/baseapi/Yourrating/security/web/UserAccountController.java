package dev.baseapi.Yourrating.security.web;

import dev.baseapi.Yourrating.security.mapper.RegisterRequestToUserAccountMapper;
import dev.baseapi.Yourrating.security.model.UserAccount;
import dev.baseapi.Yourrating.security.model.UserRole;
import dev.baseapi.Yourrating.security.service.UserAccountService;
import dev.baseapi.Yourrating.security.service.UserRoleService;
import dev.baseapi.Yourrating.security.usecase.RegisterUserAccountUseCase;
import dev.baseapi.Yourrating.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class UserAccountController {

    private final RegisterUserAccountUseCase registerUserAccountUseCase;

    public UserAccountController(RegisterUserAccountUseCase registerUserAccountUseCase) {
        this.registerUserAccountUseCase = registerUserAccountUseCase;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        this.registerUserAccountUseCase.register(registerRequest);
    }
}
