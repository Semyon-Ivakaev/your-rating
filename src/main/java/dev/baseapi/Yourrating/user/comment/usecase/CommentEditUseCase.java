package dev.baseapi.Yourrating.user.comment.usecase;

import dev.baseapi.Yourrating.user.comment.web.model.CommentEditRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;

public interface CommentEditUseCase {
    CommentResponse editComment(CommentEditRequest editRequest);
}
