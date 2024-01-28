package dev.baseapi.Yourrating.user.comment.web.model.web;

import dev.baseapi.Yourrating.user.comment.usecase.CommentAddUseCase;
import dev.baseapi.Yourrating.user.comment.web.model.CommentAddRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentAddUseCase commentAddUseCase;

    public CommentController(CommentAddUseCase commentAddUseCase) {
        this.commentAddUseCase = commentAddUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse addComment(@Valid @RequestBody CommentAddRequest addRequest) {
        return commentAddUseCase.addComment(addRequest);
    }
}
