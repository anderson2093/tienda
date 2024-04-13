package com.anderson.tiendaback.models;



import java.util.UUID;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;



@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID userId=UUID.randomUUID();
;

    @Column(name = "user_name", unique = true)
    @Nonnull
    private String username;

    @Nonnull
    @Column(name = "email", unique = true)
    private String email;

    @Nonnull
    private String password;

    public User() {
    }

    public User(UUID userId, @Nonnull String username, @Nonnull String email, @Nonnull String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nonnull String username) {
        this.username = username;
    }

    @Nonnull
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}