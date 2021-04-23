package ztpai.ztpai.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic extends Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "postSet")
    private Set<Post> postSet;

    public Topic() {
    }

    public Topic(Long assignedBy) {
        super(assignedBy);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }
}