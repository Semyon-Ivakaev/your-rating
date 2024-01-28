package dev.baseapi.Yourrating.user.profile.repository;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    boolean existsByNickname(String nickname);
}
