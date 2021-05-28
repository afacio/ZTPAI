package ztpai.ztpai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserModel> findById(Long id) {
        //TODO gdy nie ma takiego id

        return userRepository.findById(id);
    }

    public Iterable<UserModel> getAll() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        //TODO istnieje już taki użytkownik

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        //TODO gdy nie ma takiego id

        userRepository.deleteById(id);
    }


}
