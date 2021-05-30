package ztpai.ztpai.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "USER")
@JsonIgnoreProperties(value = {"forumsSet"}, allowSetters = false, allowGetters = true)
public class UserModel { //TODO dodać UserDetails

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    private boolean isEnable;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private Set<Forum> forumsSet;

    public UserModel() {
    }

    public UserModel(String email, String password, String nickName, String role) {
        this.email = email;
        this.password = password;
        this.username = nickName;
        this.role = role;
        if(role == null)
            this.role = "ROLE_USER";
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

    public Set<Forum> getForumsSet() { return forumsSet; }

    public void addForum(Forum forum){
        this.forumsSet.add(forum);
    }

    public void setForumsSet(Set<Forum> forumsSet) {
        this.forumsSet = forumsSet;
    }

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

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", isEnable=" + isEnable +
                ", forumsSet=" + forumsSet +
                '}';
    }
}