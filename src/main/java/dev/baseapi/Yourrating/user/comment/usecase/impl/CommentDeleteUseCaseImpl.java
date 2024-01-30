package dev.baseapi.Yourrating.user.comment.usecase.impl;

import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.comment.usecase.CommentDeleteUseCase;
import dev.baseapi.Yourrating.user.profile.api.service.CurrentUserProfileApiService;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class CommentDeleteUseCaseImpl implements CommentDeleteUseCase {

    private final CommentService commentService;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public CommentDeleteUseCaseImpl(CommentService commentService,
                                    CurrentUserProfileApiService currentUserProfileApiService) {
        this.commentService = commentService;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public void deleteComment(long commentId) {
        // Находим текущий профиль пользователя
        UserProfile actor = this.currentUserProfileApiService.currentUserProfile();
        // Находим профиль создателя комментария
        UserProfile ownerComment = this.commentService.findCommentById(commentId)
                .map(Comment::getUserProfile)
                .orElseThrow(() -> {
                    String errMessage = String.format("Комментарий с id = %d не существует", commentId);
                    return new RuntimeException(errMessage);
                });
        // Если не владелец комментария, то исключение
        if (!actor.equals(ownerComment)) {
            String errorMessage = String.format("Редактирование комментария с id = %s запрещено. Пользователя %s не является его владельцем",
                    commentId, actor.getNickname());
            throw new RuntimeException(errorMessage);
        }

        this.commentService.deleteComment(commentId);
    }
}
