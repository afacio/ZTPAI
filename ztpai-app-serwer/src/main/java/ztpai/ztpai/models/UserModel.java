package ztpai.ztpai.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "USER")
public class UserModel { 

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

    private String role;

    private String email;

    private String password;

    private String username;

    private boolean isEnable;

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
}