package dev.baseapi.Yourrating.user.comment.mapper.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentPageToCommentPageResponseMapper;
import dev.baseapi.Yourrating.user.comment.mapper.CommentToCommentResponseMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentPageResponse;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CommentPageToCommentPageResponseMapperImpl implements CommentPageToCommentPageResponseMapper {

    private final CommentToCommentResponseMapper commentToCommentResponseMapper;

    public CommentPageToCommentPageResponseMapperImpl(CommentToCommentResponseMapper commentToCommentResponseMapper) {
        this.commentToCommentResponseMapper = commentToCommentResponseMapper;
    }

    @Override
    public CommentPageResponse map(Page<Comment> allOwnerComments) {
        Collection<CommentResponse> commentPageResponse = allOwnerComments.stream()
                .map(this.commentToCommentResponseMapper::map)
                .collect(Collectors.toList());

        return new CommentPageResponse(
                allOwnerComments.getTotalElements(),
                allOwnerComments.isFirst(),
                allOwnerComments.isLast(),
                commentPageResponse
        );
    }
}
