package dev.baseapi.Yourrating.user.comment.mapper.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentToCommentResponseMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentResponseMapperImpl implements CommentToCommentResponseMapper {

    @Override
    public CommentResponse map(Comment model) {
        return new CommentResponse(
                model.getId(),
                model.getMessage(),
                model.getCreatedTimestamp(),
                model.getModifiedTimestamp()
        );
    }
}
