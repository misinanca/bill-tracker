package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.config.JwtTokenUtil;
import de.jonashackt.springbootvuejs.entity.*;
import de.jonashackt.springbootvuejs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/api/auth", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser) throws AuthenticationException {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenUtil.generateToken(authentication);
            CurrentUser userPrincipal = (CurrentUser) authentication.getPrincipal();
             return ResponseEntity.ok(new AuthToken(jwt, userPrincipal.getUsername(), userPrincipal.getId()));
    }

//    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
//    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
//    public String login() {
//        return  "redirect:/users/get";
//    }

}