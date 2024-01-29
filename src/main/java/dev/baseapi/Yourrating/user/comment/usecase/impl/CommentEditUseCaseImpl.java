package dev.baseapi.Yourrating.user.comment.usecase.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentEditRequestToCommentMapper;
import dev.baseapi.Yourrating.user.comment.mapper.CommentToCommentResponseMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.comment.usecase.CommentEditUseCase;
import dev.baseapi.Yourrating.user.comment.web.model.CommentEditRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import dev.baseapi.Yourrating.user.profile.api.service.CurrentUserProfileApiService;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class CommentEditUseCaseImpl implements CommentEditUseCase {

    private final CommentService commentService;
    private final CommentEditRequestToCommentMapper commentEditRequestToCommentMapper;
    private final CommentToCommentResponseMapper commentToCommentResponseMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public CommentEditUseCaseImpl(CommentService commentService,
                                  CommentEditRequestToCommentMapper commentEditRequestToCommentMapper,
                                  CommentToCommentResponseMapper commentToCommentResponseMapper,
                                  CurrentUserProfileApiService currentUserProfileApiService) {
        this.commentService = commentService;
        this.commentEditRequestToCommentMapper = commentEditRequestToCommentMapper;
        this.commentToCommentResponseMapper = commentToCommentResponseMapper;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public CommentResponse editComment(CommentEditRequest editRequest) {
        // Находим текущий профиль пользователя
        UserProfile actor = this.currentUserProfileApiService.currentUserProfile();
        // Находим профиль создателя комментария
        UserProfile ownerComment = this.commentService.findCommentById(editRequest.id())
                .map(Comment::getUserProfile)
                .orElseThrow(() -> {
                    String errMessage = String.format("Комментарий с id = %d не существует", editRequest.id());
                    return new RuntimeException(errMessage);
                });
        // Если не владелец комментария, то исключение
        if (!actor.equals(ownerComment)) {
            String errorMessage = String.format("Редактирование комментария с id = %s запрещено. Пользователя %s не является его владельцем",
                    editRequest.id(), actor.getNickname());
            throw new RuntimeException(errorMessage);
        }
        // Комментарий приводим к виду для базы данных и обновляем существующую запись
        Comment comment = this.commentEditRequestToCommentMapper.map(editRequest);
        Comment updatedComment = this.commentService.updateComment(comment);

        return this.commentToCommentResponseMapper.map(updatedComment);
    }
}
