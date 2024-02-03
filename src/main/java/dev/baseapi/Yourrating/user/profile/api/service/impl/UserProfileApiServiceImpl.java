package dev.baseapi.Yourrating.user.profile.api.service.impl;

import dev.baseapi.Yourrating.user.profile.api.service.UserProfileApiService;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import dev.baseapi.Yourrating.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileApiServiceImpl implements UserProfileApiService {

    private final UserProfileService userProfileService;

    public UserProfileApiServiceImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile findUserProfileById(Long id) {
        return this.userProfileService.findUserProfileByIdRequired(id);
    }
}
