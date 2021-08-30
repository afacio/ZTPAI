package ztpai.ztpai.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
//@JsonIgnoreProperties(value = {"forumsSet"}, allowSetters = false, allowGetters = true)
public class UserModel { //TODO dodać UserDetails

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

   // @Column(name = "role")
    private String role;

   // @Column(name = "email")
    private String email;

   // @Column(name = "password")
    private String password;

   // @Column(name = "username")
    private String username;


    //@Column(name = "forumIdList")
    @ElementCollection
    private List<Long> forumIdList;

    //@Column(name = "isTokenActivated")
    private boolean isEnable;

//    @OneToMany(mappedBy = "author")
//    @JsonManagedReference
//    private Set<Forum> forumsSet;

    public UserModel() {
    }

    public UserModel(String email, String password, String nickName, String role) {
        this.email = email;
        this.password = password;
        this.username = nickName;
        this.role = role;
        if(role == null)
            this.role = "ROLE_USER";
        this.forumIdList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nickName) {
        this.username = nickName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
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

//    public Set<Forum> getForumsSet() { return forumsSet; }
//
//    public void addForum(Forum forum){
//        this.forumsSet.add(forum);
//    }
//
//    public void setForumsSet(Set<Forum> forumsSet) {
//        this.forumsSet = forumsSet;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SimpleGrantedAuthority getAuthorities() {
        return new SimpleGrantedAuthority(role);
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public List<Long> getForumIdList() {
        return forumIdList;
    }

    public void setForumIdList(List<Long> forumIdList) {
        this.forumIdList = forumIdList;
    }

    public void setForumIdListElement(Long id){
        forumIdList.add(id);
    }
}