package ztpai.ztpai;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.ForumRepository;
import ztpai.ztpai.repository.TopicRepository;
import ztpai.ztpai.repository.UserRepository;

@Configuration
public class Start {

    private final UserRepository userRepository;
    private final ForumRepository forumRepository;
    private final TopicRepository topicRepository;

    public Start(UserRepository userRepository, ForumRepository forumRepository, TopicRepository topicRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.forumRepository = forumRepository;
        this.topicRepository = topicRepository;

        UserModel u1 = new UserModel("janusz@cebula.pl", "pasat123", "Janusz", "ROLE_ADMIN");
        u1.setPassword(passwordEncoder.encode(u1.getPassword()));
        u1.setEnable(true);
        userRepository.save(u1);

        UserModel u2= new UserModel("bogdan@blotniak.pl", "blotko123", "Bogdan", "ROLE_USER");
        u2.setPassword(passwordEncoder.encode(u2.getPassword()));
        u2.setEnable(true);
        userRepository.save(u2);

        Forum f1 = new Forum("test1","test1");
        forumRepository.save(f1);

        Forum f2 = new Forum("test2","test2");
        forumRepository.save(f2);

        Forum f3 = new Forum("test3","test3");
        forumRepository.save(f3);

        Topic t1 = new Topic("test1", f1);
        topicRepository.save(t1);
        f1.addTopicToList(t1);
        forumRepository.save(f1);

        Topic t2 = new Topic("test2", f2);
        topicRepository.save(t2);
        f2.addTopicToList(t2);
        forumRepository.save(f2);

        Topic t3 = new Topic("test3", f3);
        topicRepository.save(t3);
        f3.addTopicToList(t3);
        forumRepository.save(f3);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
