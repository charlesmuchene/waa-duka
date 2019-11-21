package io.springgeeks.duka.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "system_user")
public class SystemUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 20, nullable = false)
    @NotEmpty(message = "${NotEmpty}")
    private String surname;
    @Column(name = "other_names", length = 40, nullable = false)
    @NotEmpty(message = "${NotEmpty}")
    private String otherNames;
    @Column(unique = true, length = 80, nullable = false)
    @Email
    private String email;
    private String phone;
    @NotEmpty(message = "${NotEmpty}")
    private String susername;
    @Column(length = 256)
    @NotEmpty(message = "${NotEmpty}")
    private String password;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private Credentials credentials;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return susername;
    }


    public void setUsername(String susername) {
        this.susername = susername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
