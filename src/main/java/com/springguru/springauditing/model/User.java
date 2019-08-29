package com.springguru.springauditing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User extends BaseAudit<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @NotBlank(message = "name is required!")
    @Column(nullable = false, name = "name")
    private String name;

    @NotBlank(message = "username is required!")
    @Column(name = "username", nullable = false, unique = true, updatable = false)
    private String username;

    @NotBlank(message = "email is required!")
    @Email(message = "please enter correct email")
    @Column(name = "email", nullable = false, unique = true)
    @NaturalId
    private String email;

    @NotBlank(message = "password is required!")
    @Column(nullable = false, name = "password")
    private String password;

    @JsonIgnore
    @Column(nullable = false, name = "account_non_expired")
    private boolean accountNonExpired = true;

    @JsonIgnore
    @Column(nullable = false, name = "account_non_locked")
    private boolean accountNonLocked = true;

    @JsonIgnore
    @Column(nullable = false, name = "credentials_non_expired")
    private boolean credentialsNonExpired = true;

    @JsonIgnore
    @Column(nullable = false, name = "enabled")
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
