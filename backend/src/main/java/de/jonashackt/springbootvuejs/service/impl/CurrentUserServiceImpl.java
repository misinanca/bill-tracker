package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.entity.CurrentUser;
import de.jonashackt.springbootvuejs.entity.Role;
import de.jonashackt.springbootvuejs.service.CurrentUserService;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {
    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {

        return currentUser != null
                && (currentUser.getRole() == Role.USER || currentUser.getId().equals(userId));
    }

}
