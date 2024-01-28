package dev.baseapi.Yourrating.user.comment.mapper;

import dev.baseapi.Yourrating.security.mapper.Mapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentAddRequest;

public interface CommentAddRequestToCommentMapper extends Mapper<Comment, CommentAddRequest> {
}
