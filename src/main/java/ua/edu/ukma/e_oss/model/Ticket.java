package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "Ticket")
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "text", nullable = false)
    private String text;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sc_id")
    private SCMember solver;

    // 0 - opened
    // 1 - in process
    // 2 - rejected
    // 3 - finished
    @Column(name = "status", nullable = false)
    private byte status;

    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Ticket() {
    }

    public Ticket(@NotNull String title, @NotNull String text, @NotNull User creator, @NotNull Date createdAt) {
        this.title = title;
        this.text = text;
        this.creator = creator;
        this.status = 0;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public SCMember getSolver() {
        return solver;
    }

    public void setSolver(SCMember solver) {
        this.solver = solver;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
