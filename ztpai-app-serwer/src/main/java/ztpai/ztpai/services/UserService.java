package ztpai.ztpai.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ztpai.ztpai.exception.user.UserExistsException;
import ztpai.ztpai.exception.user.UserNotFoundException;
import ztpai.ztpai.models.Token;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.TokenRepository;
import ztpai.ztpai.repository.UserRepository;

import javax.mail.MessagingException;

import java.util.UUID;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final MailService mailService;

    public UserService(UserRepository userRepository, ForumService forumService, PasswordEncoder passwordEncoder, TokenRepository tokenRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
        this.mailService = mailService;
    }

    public Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long userId){
        return userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public UserModel getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public void addUser(UserModel user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent() || userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UserExistsException();
        else{
            user.setPassword(encodePassword(user.getPassword()));
            user.setRole("ROLE_USER");
            user.setEnable(false);
            userRepository.save(user);
            sendToken(user);
        }
    }

    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userModel -> {userRepository.deleteById(userId);}, () -> {throw new UserNotFoundException(userId);});
    }

    public void updateUser(Long id, UserModel newUser){
        UserModel oldUser = userRepository.findById(id).orElseThrow(() -> {throw new UserNotFoundException(id);});

        if(newUser.getUsername() != null) oldUser.setUsername(newUser.getUsername());
        if(newUser.getRole() != null) oldUser.setRole(newUser.getRole());
        if(newUser.getEmail() != null) oldUser.setEmail(newUser.getEmail());
        if(newUser.getPassword() != null)oldUser.setPassword(encodePassword(newUser.getPassword()));

        userRepository.save(oldUser);
    }

    private void sendToken(UserModel userModel) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();

        token.setValue(tokenValue);
        token.setUserModel(userModel);

        tokenRepository.save(token);
        //TODO uniwersalizacja url
        String url="hhtp://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(userModel.getEmail(), "Link aktywacyjny do konta na Forum", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
