package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "Ticket")
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(name = "title", nullable = false)
    public final String title;

    @NotNull
    @Column(name = "text", nullable = false)
    public final String text;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    public final User creator;

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
    public final Date createdAt;

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
}
