package ztpai.ztpai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.UserRepository;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserModel userModel = userRepository.getByUsername(username);
        if (userModel == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(userModel.getUsername()).password(userModel.getPassword()).authorities(userModel.getAuthorities()).build();
        return user;
    }

}
