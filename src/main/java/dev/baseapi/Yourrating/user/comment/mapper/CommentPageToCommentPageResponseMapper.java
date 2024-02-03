package dev.baseapi.Yourrating.user.comment.mapper;

import dev.baseapi.Yourrating.security.mapper.Mapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.web.model.CommentPageResponse;
import org.springframework.data.domain.Page;

public interface CommentPageToCommentPageResponseMapper
        extends Mapper<CommentPageResponse, Page<Comment>> {
}
