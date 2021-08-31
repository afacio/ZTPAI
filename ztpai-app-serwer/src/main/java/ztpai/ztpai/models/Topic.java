package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.List;


@Entity
public class Topic extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long topicId;
    
    private String title;
    private Long forumId;

    @OneToMany
    @Column
    @ElementCollection
    private List<Post> postsList;

    public Topic() {
    }

    public Topic(String title, Forum forum) {
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

    public List<Post> getPostList() {
        return postsList;
    }

    public void addPostsToList(Post post){
        this.postsList.add(post);
    }

    public void deletePostsFromList(Post post){
        this.postsList.remove(post);
    }

}