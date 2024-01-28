package dev.baseapi.Yourrating.user.profile.usecase.impl;

import dev.baseapi.Yourrating.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import dev.baseapi.Yourrating.user.profile.service.UserProfileService;
import dev.baseapi.Yourrating.user.profile.usecase.UserProfileRegisterUseCase;
import dev.baseapi.Yourrating.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService,
                                            UserProfileRegisterRequestToUserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @Override
    public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
        UserProfile profile = this.mapper.map(registerRequest);
        this.userProfileService.createUserProfile(profile);
    }
}
