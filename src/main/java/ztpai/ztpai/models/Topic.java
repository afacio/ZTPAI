package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
//import java.util.Set;

@Entity
public class Topic extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long topicId;
    private String title;
    private Long forumId;

    //private Set<Post> postsSet;

    public Topic() {
    }

    public Topic(String title, Forum forum, UserModel author) {
        this.forumId = forum.getForumId();
        this.title = title;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long id) {
        this.topicId = id;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Forum forum) {
        this.forumId = forum.getForumId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // public Set<Post> getPostsSet() {
    //     return postsSet;
    // }

}