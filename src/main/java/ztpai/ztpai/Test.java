package ztpai.ztpai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.models.Post;
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.models.User;
import ztpai.ztpai.repository.ForumRepository;
import ztpai.ztpai.repository.PostRepository;
import ztpai.ztpai.repository.TopicRepository;
import ztpai.ztpai.repository.UserRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Test implements CommandLineRunner {

    private UserRepository userRepository;
    private ForumRepository forumRepository;
    private TopicRepository topicRepository;
    private PostRepository postRepository;

    public Test(UserRepository userRepository, ForumRepository forumRepository, TopicRepository topicRepository, PostRepository postRepository){
        this.forumRepository = forumRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("adas.priv@gmail.com", "haslo123", "afacio");
        User user2 = new User("a.facisz@gmail.com", "qwerty123", "Facisz");

        //TODO dodać automatyczne pobieranie id z sesji zalogowanego usera
        //TODO dodać sesje
        //TODO dodać role admina itd...


        Forum forum1 = new Forum("Survival tutorials", "Minecraft", user1);
        Forum forum2 = new Forum("First blood tutorial", "Leauge of legends", user1);
        Forum forum3 = new Forum("Repentance - items guide", "The Binding of Isaac", user2);

        Topic topic1 = new Topic("How to find a diamond in 5 minuts!", forum1, user2);
        Post post1 = new Post("I hear about technic, Its true ?", topic1, user1);

        //TODO dodać funkcje dodawania forum przez usera

        user1.setForumsSet(Stream.of(forum1).collect(Collectors.toSet()));
        user2.setForumsSet(Stream.of(forum2).collect(Collectors.toSet()));
        user2.setForumsSet(Stream.of(forum3).collect(Collectors.toSet()));

//        user1.addForum(forum1);
//        user2.addForum(forum1);
//        user2.addForum(forum1);

        forum1.setTopicsSet(Stream.of(topic1).collect(Collectors.toSet()));
        topic1.setPostsSet(Stream.of(post1).collect(Collectors.toSet()));

        userRepository.save(user1);
        userRepository.save(user2);

        forumRepository.save(forum1);
        forumRepository.save(forum2);
        forumRepository.save(forum3);

        topicRepository.save(topic1);
        postRepository.save(post1);
    }
}
