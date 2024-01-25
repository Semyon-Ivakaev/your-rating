package dev.baseapi.Yourrating.security.mapper;

import dev.baseapi.Yourrating.security.model.UserAccount;
import dev.baseapi.Yourrating.security.web.model.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {
}
