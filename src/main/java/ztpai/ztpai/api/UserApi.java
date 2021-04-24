package ztpai.ztpai.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.User;
import ztpai.ztpai.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class  UserApi {

    private UserRepository userRepository;

    @Autowired
    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getUser")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/getUser/byId")
    public Optional<User> getById(@RequestParam Long index) {
        return userRepository.findById(index);
    }

    @PostMapping("/addUser")
    public User save(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
         return this.userRepository.save(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam Long index) {
        userRepository.deleteById(index);
    }
}
