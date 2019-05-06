package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.config.JwtTokenUtil;
import de.jonashackt.springbootvuejs.controller.dtos.LoginUserDTO;
import de.jonashackt.springbootvuejs.controller.dtos.UserDTO;
import de.jonashackt.springbootvuejs.entity.*;
import de.jonashackt.springbootvuejs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @CrossOrigin
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUserDTO) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateToken(authentication);
        CurrentUser userPrincipal = (CurrentUser) authentication.getPrincipal();

        return ResponseEntity.ok(new AuthToken(jwt, userPrincipal.getUsername(), userPrincipal.getId()));
    }

    @RequestMapping(value = "/public/register", method = RequestMethod.POST)
    public @ResponseBody
    User register(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPasswordHash(encryptedPassword);
        user.setRole(Role.USER);

        return userService.save(user);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}