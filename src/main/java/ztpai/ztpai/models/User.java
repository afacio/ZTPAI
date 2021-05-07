package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = {"forumsSet"}, allowSetters = false, allowGetters = true)
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
    @JsonManagedReference
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

    public Set<Forum> getForumsSet() { return forumsSet; }

    public void addForum(Forum forum){
        this.forumsSet.add(forum);
    }

    public void setForumsSet(Set<Forum> forumsSet) {
        this.forumsSet = forumsSet;
    }

}