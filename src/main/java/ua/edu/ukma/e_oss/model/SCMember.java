package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "SCMember")
@Table(name = "sc_members")
public class SCMember {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(name = "year", nullable = false)
    private String year;

    @NotNull
    @Column(name = "role", nullable = false)
    private byte role;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
