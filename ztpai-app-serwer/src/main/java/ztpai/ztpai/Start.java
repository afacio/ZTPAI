package ztpai.ztpai;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.models.Post;
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.models.UserModel;
import ztpai.ztpai.repository.ForumRepository;
import ztpai.ztpai.repository.PostRepository;
import ztpai.ztpai.repository.TopicRepository;
import ztpai.ztpai.repository.UserRepository;

@Configuration
public class Start {

    private final UserRepository userRepository;
    private final ForumRepository forumRepository;
    private final TopicRepository topicRepository;
    private final PostRepository postRepository;

    public Start(UserRepository userRepository, ForumRepository forumRepository, TopicRepository topicRepository, PostRepository postRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.forumRepository = forumRepository;
        this.topicRepository = topicRepository;
        this.postRepository = postRepository;

        UserModel u1 = new UserModel("janusz@cebula.pl", "pasat123", "Janusz", "ROLE_ADMIN");
        u1.setPassword(passwordEncoder.encode(u1.getPassword()));
        u1.setEnable(true);
        userRepository.save(u1);

        UserModel u2= new UserModel("bogdan@blotniak.pl", "blotko123", "Bogdan", "ROLE_USER");
        u2.setPassword(passwordEncoder.encode(u2.getPassword()));
        u2.setEnable(true);
        userRepository.save(u2);

        Forum f1 = new Forum("test Forum1","test Forum1");
        forumRepository.save(f1);

        Forum f2 = new Forum("test Forum2","test Forum2");
        forumRepository.save(f2);

        Forum f3 = new Forum("test Forum3","test Forum3");
        forumRepository.save(f3);

        Topic t1 = new Topic("test Topic1", f1);
        topicRepository.save(t1);
        f1.addTopicToList(t1);

        Topic t2 = new Topic("test Topic2", f1);
        topicRepository.save(t2);
        f1.addTopicToList(t2);
        
        Topic t3 = new Topic("test Topic3", f1);
        topicRepository.save(t3);
        f1.addTopicToList(t3);

        forumRepository.save(f1);

        Post p1 = new Post("test Post1", t1);
        postRepository.save(p1);
        //t1.addPostsToList(p1);

        // Post p2 = new Post("test Post2", t1);
        // postRepository.save(p2);
        // t1.addPostsToList(p2);

        // Post p3 = new Post("test Post3", t1);
        // postRepository.save(p3);
        // t1.addPostsToList(p3);

        //topicRepository.save(t1);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
