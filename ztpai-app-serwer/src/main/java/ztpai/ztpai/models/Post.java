package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Post extends Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String content;
    private int likes;
    private int dislikes;
    
    private Long topicId;

    public Post(String content, Topic topic) {
        this.topicId = topic.getTopicId();
        this.content = content;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Post() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopic(Topic topic) {
        this.topicId = topic.getTopicId();
    }

}
