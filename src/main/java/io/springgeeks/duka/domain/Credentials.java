package io.springgeeks.duka.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "credentials")
public class Credentials {

    @Id
    @NotBlank(message = "{NotBlank.user.name}")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    private String verifyPassword;
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    List<Authority> authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifyPassword='" + verifyPassword + '\'' +
                ", enabled=" + enabled +
                ", authority=" + authority +
                '}';
    }
}
