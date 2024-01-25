package dev.baseapi.Yourrating.security.usecase;

import dev.baseapi.Yourrating.security.web.model.RegisterRequest;

public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
