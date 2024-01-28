package dev.baseapi.Yourrating.security.api.service;

import dev.baseapi.Yourrating.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
