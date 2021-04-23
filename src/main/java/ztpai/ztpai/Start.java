package ztpai.ztpai;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.models.User;
import ztpai.ztpai.repository.ForumRepository;
import ztpai.ztpai.repository.UserRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Start {

    private UserRepository userRepository;
    private ForumRepository forumRepository;

    public Start(UserRepository userRepository, ForumRepository forumRepository){
        this.forumRepository = forumRepository;
        this.userRepository = userRepository;


        User user1 = new User("adas.priv@gmail.com", "haslo123", "afacio");
        User user2 = new User("a.facisz@gmail.com", "qwerty123", "Facisz");

        Forum forum1 = new Forum(1L, "How to find a diamond in 5 minuts!", "Minecraft");
        Forum forum2 = new Forum(2L, "First blood tutorial", "Leauge of legends");

        user1.setForumSet(Stream.of(forum1).collect(Collectors.toSet()));
        user2.setForumSet(Stream.of(forum2).collect(Collectors.toSet()));

        forumRepository.save(forum1);
        forumRepository.save(forum2);

        userRepository.save(user1);
        userRepository.save(user2);


    }

}
