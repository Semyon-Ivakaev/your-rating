package dev.baseapi.Yourrating.user.comment.mapper;

import dev.baseapi.Yourrating.security.mapper.Mapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentEditRequest;

public interface CommentEditRequestToCommentMapper extends Mapper<Comment, CommentEditRequest> {
}
