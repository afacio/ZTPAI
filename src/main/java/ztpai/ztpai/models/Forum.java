package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Forum extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;
    private String gameAbout;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private User author;

    @OneToMany(mappedBy = "forum")
    private Set<Topic> topicsSet;

    public Forum() {
    }

    public Forum(String title, String gameAbout, User author) {
        this.title = title;
        this.gameAbout = gameAbout;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Topic> getTopicsSet() {
        return topicsSet;
    }

    public void setTopicsSet(Set<Topic> topicsSet) {
        this.topicsSet = topicsSet;
    }


}
