package ztpai.ztpai.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.manager.UserManager;
import ztpai.ztpai.models.User;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserApi {

    private UserManager user;

    @Autowired
    public UserApi(UserManager user) {
        this.user = user;
    }

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return user.getAll();
    }

    @GetMapping
    public Optional<User> getById(@RequestParam Long index) {
        return user.findById(index);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return this.user.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
         return this.user.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long index) {
        user.deleteById(index);
    }
}
