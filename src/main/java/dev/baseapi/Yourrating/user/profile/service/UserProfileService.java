package dev.baseapi.Yourrating.user.profile.service;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    Optional<UserProfile> findUserProfileById(long userProfileId);
}
