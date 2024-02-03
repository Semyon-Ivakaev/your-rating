package dev.baseapi.Yourrating.user.comment.usecase;

import dev.baseapi.Yourrating.user.comment.web.model.CommentFindRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CommentFindUseCase {

    CommentPageResponse findComments(@Valid CommentFindRequest findRequest);
}
