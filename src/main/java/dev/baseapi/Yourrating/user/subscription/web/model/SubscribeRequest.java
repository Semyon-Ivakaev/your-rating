package dev.baseapi.Yourrating.user.subscription.web.model;

import jakarta.validation.constraints.NotNull;

public record SubscribeRequest(
        @NotNull Long followedId
) {
}
