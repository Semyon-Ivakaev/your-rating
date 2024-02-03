package dev.baseapi.Yourrating.user.subscription.usecase;

import dev.baseapi.Yourrating.user.subscription.web.model.SubscribeRequest;

public interface SubscriptionAddUseCase {
    void subscribe(SubscribeRequest subscribeRequest);
}
