package dev.baseapi.Yourrating.security.usecase;

import dev.baseapi.Yourrating.security.web.model.AccessToken;
import dev.baseapi.Yourrating.security.web.model.LoginRequest;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest loginRequest);
}
