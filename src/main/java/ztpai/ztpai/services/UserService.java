package ztpai.ztpai.services;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ztpai.ztpai.exception.forum.ForumNotFoundException;
import ztpai.ztpai.exception.user.UserExistsException;
import ztpai.ztpai.exception.user.UserNotFoundException;
import ztpai.ztpai.models.Token;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.TokenRepository;
import ztpai.ztpai.repository.UserRepository;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final ForumService forumService;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final MailService mailService;

    public UserService(UserRepository userRepository, ForumService forumService, PasswordEncoder passwordEncoder, TokenRepository tokenRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.forumService = forumService;
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
        //TODO nie działa usuwanie dla nowo utworzonych userów przez metode post
        userRepository.findById(userId).ifPresentOrElse(userModel -> {userRepository.deleteById(userId);}, () -> {throw new UserNotFoundException(userId);});
    }

    public void updateUser(Long id, UserModel newUser){
//TODO doać aby nie można było podmieniać danych na już istniejące
        UserModel oldUser = userRepository.findById(id).orElseThrow(() -> {throw new UserNotFoundException(id);});

        if(newUser.getUsername() != null) oldUser.setUsername(newUser.getUsername());
        if(newUser.getRole() != null) oldUser.setRole(newUser.getRole());
        if(newUser.getEmail() != null) oldUser.setEmail(newUser.getEmail());
        //if(newUser.getForumsSet() != null) oldUser.setForumsSet(newUser.getForumsSet());
        if(newUser.getPassword() != null)oldUser.setPassword(encodePassword(newUser.getPassword()));
        if(newUser.getForumIdList() != null)oldUser.setForumIdList(newUser.getForumIdList());

        userRepository.save(oldUser);
    }

    public void addForumIdToList(Long userId, Long forumId){
        userRepository.findById(userId).ifPresentOrElse(user -> {
                    forumService.findById(forumId).ifPresentOrElse(forum -> {
                        user.setForumIdListElement(forumId);
                        userRepository.save(user);
                    },() -> {throw new ForumNotFoundException(forumId);});},
                () -> {throw new UserNotFoundException(userId);});
    }

    public List<Long> getUserForumIdList(Long userId){
        //TODO gdy lista jest pusta zrobić obsługę wyjątków
        UserModel userModel = userRepository.findById(userId).orElseThrow(() -> {throw new UserNotFoundException(userId);});
        return userModel.getForumIdList();
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
