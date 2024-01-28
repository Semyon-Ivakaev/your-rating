package dev.baseapi.Yourrating.user.comment.usecase.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentAddRequestToCommentMapper;
import dev.baseapi.Yourrating.user.comment.mapper.CommentToCommentResponseMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.comment.usecase.CommentAddUseCase;
import dev.baseapi.Yourrating.user.comment.web.model.CommentAddRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import org.springframework.stereotype.Component;

@Component
public class CommentAddUseCaseFacade implements CommentAddUseCase {

    private final CommentAddRequestToCommentMapper commentAddRequestToCommentMapper;
    private final CommentToCommentResponseMapper commentToCommentResponseMapper;
    private final CommentService commentService;

    public CommentAddUseCaseFacade(CommentAddRequestToCommentMapper commentAddRequestToCommentMapper,
                                   CommentToCommentResponseMapper commentToCommentResponseMapper,
                                   CommentService commentService) {
        this.commentAddRequestToCommentMapper = commentAddRequestToCommentMapper;
        this.commentToCommentResponseMapper = commentToCommentResponseMapper;
        this.commentService = commentService;
    }

    @Override
    public CommentResponse addComment(CommentAddRequest addRequest) {
        Comment mappedComment = this.commentAddRequestToCommentMapper.map(addRequest);
        Comment createdComment = this.commentService.createComment(mappedComment);

        return this.commentToCommentResponseMapper.map(createdComment);
    }
}
