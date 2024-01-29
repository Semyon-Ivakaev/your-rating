package dev.baseapi.Yourrating.user.comment.mapper.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentEditRequestToCommentMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.comment.web.model.CommentEditRequest;
import org.springframework.stereotype.Component;

@Component
public class CommentEditRequestToCommentMapperImpl implements CommentEditRequestToCommentMapper {

    private final CommentService commentService;

    public CommentEditRequestToCommentMapperImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public Comment map(CommentEditRequest request) {

        Comment currentComment = this.commentService.findCommentById(request.id()).orElseThrow(() -> {
            String errMessage = String.format("Комментарий с id = %d не существует", request.id());
            return new RuntimeException(errMessage);
        });

        currentComment.setMessage(request.message());

        return currentComment;
    }
}
