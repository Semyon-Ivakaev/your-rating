package dev.baseapi.Yourrating.user.subscription.usecase.impl;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import dev.baseapi.Yourrating.user.subscription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.baseapi.Yourrating.user.subscription.mapper.UnsubscribeRequestToSubscriptionMapper;
import dev.baseapi.Yourrating.user.subscription.model.Subscription;
import dev.baseapi.Yourrating.user.subscription.service.SubscriptionService;
import dev.baseapi.Yourrating.user.subscription.usecase.SubscriptionDeleteUseCase;
import dev.baseapi.Yourrating.user.subscription.web.model.UnsubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDeleteUseCaseFacade implements SubscriptionDeleteUseCase {

    private final UnsubscribeRequestToSubscriptionMapper unsubscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionDeleteUseCaseFacade(UnsubscribeRequestToSubscriptionMapper unsubscriptionMapper,
                                           SubscriptionService subscriptionService) {
        this.unsubscriptionMapper = unsubscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void unsubscribe(UnsubscribeRequest unsubscribeRequest) {
        Subscription subscription = this.unsubscriptionMapper.map(unsubscribeRequest);
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if (follower.equals(followed)) {
            throw new RuntimeException("Отписка от самого себя не имеет смысла");
        }

        if (!this.subscriptionService.existsSubscription(subscription)) {
            String errorMessage = String.format("Вы не были подписаны на %s", followed.getNickname());
            throw new RuntimeException(errorMessage);
        }

        this.subscriptionService.deleteSubscription(subscription);
    }
}
