package ztpai.ztpai.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String email;
    private String password;
    private String nickName;

    @OneToMany
    @JoinColumn(name = "forumAuthorId")
    private Set<Forum> forumSet;

    @OneToMany
    @JoinColumn(name = "topicAuthorId")
    private Set<Topic> topicSet;

    @OneToMany
    @JoinColumn(name = "postAuthorId")
    private Set<Post> postSet;

    public User() {
    }

    public User(String email, String password, String nickName) {

        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Forum> getForumSet() {
        return forumSet;
    }

    public void setForumSet(Set<Forum> forumSet) {
        this.forumSet = forumSet;
    }

    public Set<Topic> getTopicSet() {
        return topicSet;
    }

    public void setTopicSet(Set<Topic> topicSet) {
        this.topicSet = topicSet;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }
}