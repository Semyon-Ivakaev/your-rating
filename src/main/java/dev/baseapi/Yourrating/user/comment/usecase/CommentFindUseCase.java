package dev.baseapi.Yourrating.user.comment.usecase;

import dev.baseapi.Yourrating.user.comment.web.model.CommentFindRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

@Validated
public interface CommentFindUseCase {

    Collection<CommentResponse> findComments(@Valid CommentFindRequest findRequest);
}
