package dev.baseapi.Yourrating.user.profile.api.service;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;

public interface UserProfileApiService {
    UserProfile findUserProfileById(Long id);
}
