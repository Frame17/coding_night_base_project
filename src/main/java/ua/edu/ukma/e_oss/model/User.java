package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    public final String name;

    public User(@NotNull String name) {
        this.name = name;
    }
}
