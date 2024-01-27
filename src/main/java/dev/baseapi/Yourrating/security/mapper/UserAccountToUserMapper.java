package dev.baseapi.Yourrating.security.mapper;

import dev.baseapi.Yourrating.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount> {

}
