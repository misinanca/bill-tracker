package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.entity.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
