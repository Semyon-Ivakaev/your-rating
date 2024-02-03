package dev.baseapi.Yourrating.user.comment.repository;

import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findAllByUserProfile(UserProfile owner, Pageable pageable);
}
