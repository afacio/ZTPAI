package ztpai.ztpai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.UserModel;
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
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/getUser/byId")
    public Optional<UserModel> getById(@RequestParam Long index) {
        return userRepository.findById(index);
    }

    @PostMapping("/addUser")
    public UserModel save(@RequestBody UserModel userModel){
        return this.userRepository.save(userModel);
    }

    @PutMapping("/updateUser")
    public UserModel updateUser(@RequestBody UserModel userModel){
         return this.userRepository.save(userModel);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam Long index) {
        userRepository.deleteById(index);
    }
}
