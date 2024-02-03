package dev.baseapi.Yourrating.user.subscription.mapper;

import dev.baseapi.Yourrating.security.mapper.Mapper;
import dev.baseapi.Yourrating.user.subscription.model.Subscription;
import dev.baseapi.Yourrating.user.subscription.web.model.SubscribeRequest;

public interface SubscribeRequestToSubscriptionMapper extends Mapper<Subscription, SubscribeRequest> {
}
