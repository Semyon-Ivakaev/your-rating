package dev.baseapi.Yourrating.user.comment.web.model;

import java.util.Collection;

public record CommentPageResponse(
        long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<CommentResponse> comments
) {
}
