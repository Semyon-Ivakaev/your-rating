package dev.baseapi.Yourrating.user.comment.web;

import dev.baseapi.Yourrating.user.comment.usecase.CommentAddUseCase;
import dev.baseapi.Yourrating.user.comment.usecase.CommentDeleteUseCase;
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
    private final CommentDeleteUseCase commentDeleteUseCase;

    public CommentController(CommentAddUseCase commentAddUseCase, CommentEditUseCase commentEditUseCase, CommentDeleteUseCase commentDeleteUseCase) {
        this.commentAddUseCase = commentAddUseCase;
        this.commentEditUseCase = commentEditUseCase;
        this.commentDeleteUseCase = commentDeleteUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse addComment(@Valid @RequestBody CommentAddRequest addRequest) {
        return this.commentAddUseCase.addComment(addRequest);
    }

    @PutMapping
    public CommentResponse editComment(@Valid @RequestBody CommentEditRequest editRequest) {
        return this.commentEditUseCase.editComment(editRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable long commentId) {
        this.commentDeleteUseCase.deleteComment(commentId);
    }
}
