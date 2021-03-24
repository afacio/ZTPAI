package ztpai.ztpai.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ztpai.ztpai.models.User;
import ztpai.ztpai.repository.UserRepository;

import java.util.Optional;

@Service
public class UserManager {

    private UserRepository userRepo;

    @Autowired
    public UserManager(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public Iterable<User> getAll() {
        return userRepo.findAll();
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
