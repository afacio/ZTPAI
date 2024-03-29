package ztpai.ztpai.controller;

import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getUser")
    public Iterable<UserModel> getAll() {
        return userService.getAllUsers();
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getUser/{id}")
    public UserModel getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // @GetMapping("/getUser/{username}")
    // public UserModel getUserByUsername(@PathVariable String username){
    //     return userService.getUserByUsername(username);
    // }

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
        userService.deleteUser(id);
    }

    // @GetMapping("getUserForumIdList/{id}")
    // public List<Long> getUserForumIdList(@PathVariable Long id){
    //     return userService.getUserForumIdList(id);
    // }

    // @PostMapping("addForumIdToList/{userId}/{forumId}")
    // public void addForumIdToList(@PathVariable Long userId, @PathVariable Long forumId){
    //     userService.addForumIdToList(userId, forumId);
    // }
}
