package dev.baseapi.Yourrating.user.comment.web.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CommentFindRequest(
        @Min(0) int page,
        @Min(25) @Max(100) int limit
) {
}
