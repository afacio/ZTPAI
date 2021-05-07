package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "forum_id")
    @JsonBackReference
    private Forum forum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    private User author;

    @JsonBackReference
    @OneToMany(mappedBy = "topic")
    private Set<Post> postsSet;

    public Topic() {
    }

    public Topic(String title, Forum forum, User author) {
        this.forum = forum;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


}