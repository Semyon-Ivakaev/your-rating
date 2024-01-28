package dev.baseapi.Yourrating.user.comment.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CommentAddRequest(
        @NotBlank
        @Size(min = 5, max = 180)
        String message
) {

}
