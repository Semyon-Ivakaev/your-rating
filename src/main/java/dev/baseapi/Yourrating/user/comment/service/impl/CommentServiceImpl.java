package dev.baseapi.Yourrating.user.comment.service.impl;

import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.repository.CommentRepository;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findCommentById(long commentId) {
        return this.commentRepository.findById(commentId);
    }

    @Override
    public void deleteComment(long commentId) {
        this.commentRepository.deleteById(commentId);
    }

    @Override
    public Page<Comment> findAllComments(UserProfile owner, Pageable pageable) {
        return this.commentRepository.findAllByUserProfile(owner, pageable);
    }
}
