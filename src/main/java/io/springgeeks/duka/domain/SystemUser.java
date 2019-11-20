package io.springgeeks.duka.domain;

import javax.persistence.*;

@Entity
@Table(name = "system_user")
public class SystemUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 20, nullable = false)
    private String surname;
    @Column(name = "other_names", length = 40, nullable = false)
    private String otherNames;
    @Column(unique = true, length = 80, nullable = false)
    private String email;
    private String phone;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(length = 256)
    private String password;

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
}
