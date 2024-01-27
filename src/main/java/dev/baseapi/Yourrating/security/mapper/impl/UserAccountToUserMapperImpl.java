package dev.baseapi.Yourrating.security.mapper.impl;

import dev.baseapi.Yourrating.security.mapper.UserAccountToUserMapper;
import dev.baseapi.Yourrating.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {
    @Override
    public User map(UserAccount userAccount) {
        return new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getAuthorities()
        );
    }
}
