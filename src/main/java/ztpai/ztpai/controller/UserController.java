package ztpai.ztpai.controller;

import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.UserRepository;
import ztpai.ztpai.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public Iterable<UserModel> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getUser/{id}")
    public UserModel getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserModel userModel){
        userService.addUser(userModel);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@RequestBody UserModel newUser, @PathVariable Long id){
        userService.updateUser(id, newUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
