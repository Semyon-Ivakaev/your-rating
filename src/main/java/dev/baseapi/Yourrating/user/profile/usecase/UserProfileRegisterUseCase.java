package dev.baseapi.Yourrating.user.profile.usecase;

import dev.baseapi.Yourrating.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {
    void registerUserProfile(UserProfileRegisterRequest registerRequest);
}
