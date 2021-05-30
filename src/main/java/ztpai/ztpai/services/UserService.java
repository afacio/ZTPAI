package ztpai.ztpai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ztpai.ztpai.models.Token;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.TokenRepository;
import ztpai.ztpai.repository.UserRepository;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final MailService mailService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
        this.mailService = mailService;
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
        user.setEnable(false);
        userRepository.save(user);
        sendToken(user);
    }

    private void sendToken(UserModel userModel) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();

        token.setValue(tokenValue);
        token.setUserModel(userModel);

        tokenRepository.save(token);

        String url="hhtp://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(userModel.getEmail(), "Link aktywacyjny do konta na Forum", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public void deleteById(Long id) {
        //TODO gdy nie ma takiego id

        userRepository.deleteById(id);
    }


}
