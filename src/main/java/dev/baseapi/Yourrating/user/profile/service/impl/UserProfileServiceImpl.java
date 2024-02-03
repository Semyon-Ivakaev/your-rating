package dev.baseapi.Yourrating.user.profile.service.impl;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import dev.baseapi.Yourrating.user.profile.repository.UserProfileRepository;
import dev.baseapi.Yourrating.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void createUserProfile(UserProfile userProfile) {

        if (this.userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = String
                    .format("Профиль пользователя с данным Id = %d ранее уже был создан", userProfile.getId());
            throw new RuntimeException(errorMessage);
        }

        if (this.userProfileRepository.existsByNickname(userProfile.getNickname())) {
            String errorMessage = String
                    .format("Профиль пользователя с данным Nickname = %s ранее уже был создан", userProfile.getNickname());
            throw new RuntimeException(errorMessage);
        }

        this.userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findUserProfileByIdRequired(long userProfileId) {
        return this.userProfileRepository.findById(userProfileId)
                .orElseThrow(() -> {
            String errorMessage = String.format("Профиля пользователя с id = '%d' в системе не существует",
                    userProfileId);
            return new RuntimeException(errorMessage);
        });
    }
}
