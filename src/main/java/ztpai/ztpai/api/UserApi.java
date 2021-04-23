package ztpai.ztpai.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.manager.UserService;
import ztpai.ztpai.models.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class  UserApi {

    private UserService user;

    @Autowired
    public UserApi(UserService user) {
        this.user = user;
    }

    @GetMapping("/getUser")
    public Iterable<User> getAll() {
        return user.getAll();
    }

    @GetMapping("/getUser/byId")
    public Optional<User> getById(@RequestParam Long index) {
        return user.findById(index);
    }

    @PostMapping("/addUser")
    public User save(@RequestBody User user){
        return this.user.save(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
         return this.user.save(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam Long index) {
        user.deleteById(index);
    }
}
