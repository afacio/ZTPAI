package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Forum extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long forumId;

    private String title;
    private String gameAbout;

    @ElementCollection
    private List<Long> listOfUserModerators;

    @ElementCollection
    private List<Long> listOfUserAdministrators;

    @ElementCollection
    private List<Long> topicIdList;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "author_id")
//    @JsonBackReference
//    private UserModel author;

//    @OneToMany(mappedBy = "forum")
//    @JsonManagedReference
//    private Set<Topic> topicsSet;

    public Forum() {
    }

    public Forum(String title, String gameAbout, UserModel author) {

        this.listOfUserAdministrators = new ArrayList<>();
        this.listOfUserModerators = new ArrayList<>();
        this.topicIdList = new ArrayList<>();

        this.title = title;
        this.gameAbout = gameAbout;
        this.listOfUserAdministrators.add(author.getUserId());
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

    public List<Long> getListOfUserModerators() {
        return listOfUserModerators;
    }

    public void setListOfUserModerators(List<Long> listOfUserModerators) {
        this.listOfUserModerators = listOfUserModerators;
    }

    public List<Long> getListOfUserAdministrators() {
        return listOfUserAdministrators;
    }

    public void setListOfUserAdministrators(List<Long> listOfUserAdministrators) {
        this.listOfUserAdministrators = listOfUserAdministrators;
    }

    public List<Long> getTopicIdList() {
        return topicIdList;
    }

    public void setTopicIdList(List<Long> topicIdList) {
        this.topicIdList = topicIdList;
    }

    public void addTopicToForum(Long topicId){
        this.topicIdList.add(topicId);
    }

//    public UserModel getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(UserModel author) {
//        this.author = author;
//    }
//
//    public Set<Topic> getTopicsSet() {
//        return topicsSet;
//    }
//
//    public void setTopicsSet(Set<Topic> topicsSet) {
//        this.topicsSet = topicsSet;
//    }


}
