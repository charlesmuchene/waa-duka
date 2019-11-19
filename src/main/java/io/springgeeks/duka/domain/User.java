package io.springgeeks.duka.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "{NotBlank.user.name}")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "{NotBlank.user.name}")
    @Column(name = "last_name")
    private String lastName;

    @Valid
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credentials")
    private Credentials credentials;

}
