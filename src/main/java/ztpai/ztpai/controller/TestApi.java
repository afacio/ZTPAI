package ztpai.ztpai.controller;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.Token;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.TokenRepository;
import ztpai.ztpai.repository.UserRepository;
import ztpai.ztpai.services.UserService;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

@Controller
public class TestApi {

    private final UserService userService;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public TestApi(UserService userService, UserRepository userRepository, TokenRepository tokenRepository){
        this.userService = userService;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }



    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("authorities", authorities);

        return "hello";
    }

    @GetMapping("/sign-up")
    public String signup(Model model){
        model.addAttribute("user", new UserModel());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(UserModel userModel){
        userService.addUser(userModel);

        return "sign-up";
    }

    @GetMapping("/token")
    public String token(@RequestParam String value){
        Token token = tokenRepository.findByValue(value);
        UserModel userModel = token.getUserModel();
        userModel.setEnable(true);
        userRepository.save(userModel);

        return "sign-up";
    }

}
