package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Forum extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long forumId;

    private String title;
    private String gameAbout;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private UserModel author;


    @OneToMany(mappedBy = "forum")
    @JsonManagedReference
    private Set<Topic> topicsSet;

    public Forum() {
    }

    public Forum(String title, String gameAbout, UserModel author) {
        this.title = title;
        this.gameAbout = gameAbout;
        this.author = author;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long id) {
        this.forumId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGameAbout() {
        return gameAbout;
    }

    public void setGameAbout(String gameAbout) {
        this.gameAbout = gameAbout;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public Set<Topic> getTopicsSet() {
        return topicsSet;
    }

    public void setTopicsSet(Set<Topic> topicsSet) {
        this.topicsSet = topicsSet;
    }


}
