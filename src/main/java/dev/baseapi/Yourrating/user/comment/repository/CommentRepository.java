package dev.baseapi.Yourrating.user.comment.repository;

import dev.baseapi.Yourrating.user.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
