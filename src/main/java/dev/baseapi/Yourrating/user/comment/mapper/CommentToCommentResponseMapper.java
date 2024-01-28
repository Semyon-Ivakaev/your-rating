package dev.baseapi.Yourrating.user.comment.mapper;

import dev.baseapi.Yourrating.security.mapper.Mapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;

public interface CommentToCommentResponseMapper extends Mapper<CommentResponse, Comment> {
}
