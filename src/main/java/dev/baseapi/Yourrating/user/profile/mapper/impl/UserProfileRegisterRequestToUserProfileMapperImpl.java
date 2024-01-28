package dev.baseapi.Yourrating.user.profile.mapper.impl;

import dev.baseapi.Yourrating.security.api.model.CurrentUserApiModel;
import dev.baseapi.Yourrating.security.api.service.IdentityApiService;
import dev.baseapi.Yourrating.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import dev.baseapi.Yourrating.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterRequestToUserProfileMapperImpl implements UserProfileRegisterRequestToUserProfileMapper {

    private final IdentityApiService identityApiService;

    public UserProfileRegisterRequestToUserProfileMapperImpl(IdentityApiService identityApiService) {
        this.identityApiService = identityApiService;
    }

    @Override
    public UserProfile map(UserProfileRegisterRequest registerRequest) {

        CurrentUserApiModel currentUserApiModel = this.identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Для создания профиля пользователь должен быть атворизован в системе"));

        UserProfile userProfile = new UserProfile();
        userProfile.setId(currentUserApiModel.userAccountId());
        userProfile.setNickname(registerRequest.nickname());
        userProfile.setImageLink(registerRequest.imageLink());

        return userProfile;
    }
}
