package dev.baseapi.Yourrating.user.comment.mapper.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentAddRequestToCommentMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentAddRequest;
import dev.baseapi.Yourrating.user.profile.api.service.CurrentUserProfileApiService;
import org.springframework.stereotype.Component;

@Component
public class CommentAddRequestToCommentMapperImpl implements CommentAddRequestToCommentMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;

    public CommentAddRequestToCommentMapperImpl(CurrentUserProfileApiService currentUserProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public Comment map(CommentAddRequest request) {

        Comment comment = new Comment();
        comment.setUserProfile(this.currentUserProfileApiService.currentUserProfile());
        comment.setMessage(request.message());

        return comment;
    }
}
