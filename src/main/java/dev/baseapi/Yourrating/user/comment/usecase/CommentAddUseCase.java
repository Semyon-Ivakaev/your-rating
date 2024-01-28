package dev.baseapi.Yourrating.user.comment.usecase;

import dev.baseapi.Yourrating.user.comment.web.model.CommentAddRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;

public interface CommentAddUseCase {
    CommentResponse addComment(CommentAddRequest commentAddRequest);
}
