package dev.baseapi.Yourrating.user.subscription.service.impl;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import dev.baseapi.Yourrating.user.subscription.model.Subscription;
import dev.baseapi.Yourrating.user.subscription.repository.SubscriptionRepository;
import dev.baseapi.Yourrating.user.subscription.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void createSubscription(Subscription subscription) {
        this.subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Subscription subscription) {
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();
        this.subscriptionRepository
                .findByFollowerAndFollowed(follower, followed)
                .ifPresent(this.subscriptionRepository::delete);
    }

    @Override
    public boolean existsSubscription(Subscription subscription) {
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        return this.subscriptionRepository.existsByFollowerAndFollowed(follower, followed);
    }
}
