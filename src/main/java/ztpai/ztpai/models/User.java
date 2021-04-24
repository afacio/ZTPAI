package ztpai.ztpai.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickName")
    private String nickName;

    @OneToMany(mappedBy = "author")
    private Set<Forum> forumsSet;

    public User() {
    }

    public User(String email, String password, String nickName) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Forum> getForumSet() {
        return forumsSet;
    }

    public void setForumSet(Set<Forum> forumSet) {
        this.forumsSet = forumSet;
    }

    public Set<Forum> getForumsSet() {
        return forumsSet;
    }

    public void setForumsSet(Set<Forum> forumsSet) {
        this.forumsSet = forumsSet;
    }
}