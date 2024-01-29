package dev.baseapi.Yourrating.user.comment.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentEditRequest(
        @NotNull
        long id,
        @NotBlank
        @Size(min = 5, max = 180)
        String message
) {
}
