package dev.baseapi.Yourrating.user.subscription.usecase;

import dev.baseapi.Yourrating.user.subscription.web.model.UnsubscribeRequest;

public interface SubscriptionDeleteUseCase {
    void unsubscribe(UnsubscribeRequest unsubscribeRequest);
}
