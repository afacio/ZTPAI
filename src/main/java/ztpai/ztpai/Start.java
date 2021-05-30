package ztpai.ztpai;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.UserRepository;

@Configuration
public class Start {

    private final UserRepository userRepository;

    public Start(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;

        UserModel u1 = new UserModel("janusz@cebula.pl", "pasat123", "Janusz", "ROLE_ADMIN");
        u1.setPassword(passwordEncoder.encode(u1.getPassword()));
        u1.setEnable(true);
        userRepository.save(u1);

        UserModel u2= new UserModel("bogdan@blotniak.pl", "blotko123", "Bogdan", "ROLE_USER");
        u2.setPassword(passwordEncoder.encode(u2.getPassword()));
        u2.setEnable(true);
        userRepository.save(u2);
    }
}
