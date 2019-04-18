package de.jonashackt.springbootvuejs.service.impl;


import de.jonashackt.springbootvuejs.entity.CurrentUser;
import de.jonashackt.springbootvuejs.entity.User;
import de.jonashackt.springbootvuejs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CurrentUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", username)));
        return new CurrentUser(user);
    }
}
