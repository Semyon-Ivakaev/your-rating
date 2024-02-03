package dev.baseapi.Yourrating.user.subscription.service;

import dev.baseapi.Yourrating.user.subscription.model.Subscription;

public interface SubscriptionService {
    void createSubscription(Subscription subscription);
    void deleteSubscription(Subscription subscription);
    boolean existsSubscription(Subscription subscription);
}
