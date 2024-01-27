package dev.baseapi.Yourrating.security.service.impl;

import dev.baseapi.Yourrating.security.mapper.UserAccountToUserMapper;
import dev.baseapi.Yourrating.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserAccountService userAccountService;
    private UserAccountToUserMapper userAccountToUserMapper;

    public UserDetailsServiceImpl(UserAccountService userAccountService, UserAccountToUserMapper userAccountToUserMapper) {
        this.userAccountService = userAccountService;
        this.userAccountToUserMapper = userAccountToUserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userAccountService
                .findUserByUsername(username)
                .map(this.userAccountToUserMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("Неверные учетные данные пользователя"));
    }
}
