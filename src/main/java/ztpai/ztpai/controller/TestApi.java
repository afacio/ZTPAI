package ztpai.ztpai.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.services.UserService;

@Controller
public class TestApi {

    private UserService userService;

    public TestApi(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/for-admin")
    public String forAdmin(){
        return "hello-admin";
    }

    @GetMapping("/for-user")
    public String forUser(){
        return "hello-user";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hi there!";
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

}
