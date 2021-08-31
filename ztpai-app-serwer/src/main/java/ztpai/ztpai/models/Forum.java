package ztpai.ztpai.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Forum extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long forumId;
    
    private String title;
    private String gameAbout;

    @OneToMany
    private List<Topic> topicList;


    public Forum() {
    }

    public Forum(String title, String gameAbout) {
        this.topicList = new ArrayList<>();
        this.title = title;
        this.gameAbout = gameAbout;
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

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void addTopicToList(Topic topic){
        this.topicList.add(topic);
    }

    public void deleteTopicFromList(Topic topic){
        this.topicList.remove(topic);
    }

}
