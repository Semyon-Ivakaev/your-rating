package dev.baseapi.Yourrating.user.comment.web.model;

import java.time.Instant;

public record CommentResponse(
        long id,
        String message,
        Instant createdTimestamp
) {
}
