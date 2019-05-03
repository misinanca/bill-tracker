package de.jonashackt.springbootvuejs.controller.impl;

import de.jonashackt.springbootvuejs.controller.UserRestApi;
import de.jonashackt.springbootvuejs.entity.User;
import de.jonashackt.springbootvuejs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController implements UserRestApi {

    private final UserService userService;

    @Autowired
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }


    @Override
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @Override
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @Override
    public @ResponseBody User register(@RequestBody User user) {
        return userService.save(user);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }
}
