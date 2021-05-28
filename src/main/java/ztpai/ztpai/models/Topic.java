package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long topicId;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private UserModel author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "forum_id")
    @JsonBackReference
    private Forum forum;

    @OneToMany(mappedBy = "topic")
    @JsonManagedReference
    private Set<Post> postsSet;

    public Topic() {
    }

    public Topic(String title, Forum forum, UserModel author) {
        this.forum = forum;
        this.title = title;
        this.author = author;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long id) {
        this.topicId = id;
    }

    //@JsonIgnore
    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Post> getPostsSet() {
        return postsSet;
    }

    public void setPostsSet(Set<Post> postsSet) {
        this.postsSet = postsSet;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }


}