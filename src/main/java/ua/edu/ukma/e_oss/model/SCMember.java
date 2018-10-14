package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "SCMember")
@Table(name = "sc_members")
public class SCMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "year", nullable = false)
    private String year;

    // 0 - member
    // 1 - assoc member
    @Column(name = "role", nullable = false)
    private byte role;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public SCMember() {
    }

    public SCMember(@NotNull String year, byte role, @NotNull User user) {
        this.year = year;
        this.role = role;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
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
