package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api")
public interface UserRestApi {

//    @GetMapping("/{id}")
//    User findById(@PathVariable Long id);

    @PostMapping("/update")
    User update(final User user);

    @GetMapping("/findAll")
    List<User> findAll();

}
