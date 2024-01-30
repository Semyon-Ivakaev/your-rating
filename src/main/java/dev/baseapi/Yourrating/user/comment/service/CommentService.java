package dev.baseapi.Yourrating.user.comment.service;

import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    Optional<Comment> findCommentById(long commentId);

    void deleteComment(long commentId);

    Collection<Comment> findAllComments(UserProfile owner, Pageable pageable);
}
