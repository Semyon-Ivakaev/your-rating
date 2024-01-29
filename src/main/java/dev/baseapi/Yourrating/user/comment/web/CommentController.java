package dev.baseapi.Yourrating.user.comment.web;

import dev.baseapi.Yourrating.user.comment.usecase.CommentAddUseCase;
import dev.baseapi.Yourrating.user.comment.usecase.CommentEditUseCase;
import dev.baseapi.Yourrating.user.comment.web.model.CommentAddRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentEditRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentAddUseCase commentAddUseCase;
    private final CommentEditUseCase commentEditUseCase;

    public CommentController(CommentAddUseCase commentAddUseCase, CommentEditUseCase commentEditUseCase) {
        this.commentAddUseCase = commentAddUseCase;
        this.commentEditUseCase = commentEditUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse addComment(@Valid @RequestBody CommentAddRequest addRequest) {
        return commentAddUseCase.addComment(addRequest);
    }

    @PutMapping
    public CommentResponse editComment(@Valid @RequestBody CommentEditRequest editRequest) {
        return commentEditUseCase.editComment(editRequest);
    }
}
