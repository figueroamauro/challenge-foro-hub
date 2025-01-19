package ar.com.old.challenge_foro_hub.models.entitites;

import ar.com.old.challenge_foro_hub.validators.UserValidator;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(Long id, String userName, String password, String email) {
        UserValidator.validateUserName(userName);
        UserValidator.validateEmail(email);
        UserValidator.validatePassword(password);
        UserValidator.validateId(id);
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        UserValidator.validateId(id);
        this.id = id;
    }

    public void setUserName(String userName) {
        UserValidator.validateUserName(userName);
        this.userName = userName;
    }

    public void setPassword(String password) {
        UserValidator.validatePassword(password);
        this.password = password;
    }

    public void setEmail(String email) {
        UserValidator.validateEmail(email);
        this.email = email;
    }
}
