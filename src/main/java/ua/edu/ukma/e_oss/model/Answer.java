package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "Answer")
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sc_id")
    private SCMember scId = null;

    // 0 - opened
    // 1 - in process
    // 2 - rejected
    // 3 - finished
    @Column(name = "status")
    private Byte status = null;

    @Column(name = "reply")
    private String reply;

    @NotNull
    @Column(name = "answered_at", nullable = false)
    private Date answeredAt;

    public Answer() {
    }

    // for user
    public Answer(@NotNull Ticket ticket, @NotNull User user, @NotNull String reply, @NotNull Date answeredAt) {
        this.ticket = ticket;
        this.user = user;
        this.reply = reply;
        this.answeredAt = answeredAt;
    }

    // for sc member
    public Answer(@NotNull Ticket ticket, @NotNull User user, SCMember scId, Byte status, String reply, @NotNull Date answeredAt) {
        this.ticket = ticket;
        this.user = user;
        this.scId = scId;
        if(scId != null)
            this.ticket.setSolver(scId);
        this.status = status;
        if (status != null)
            this.ticket.setStatus(status);
        this.reply = reply;
        this.answeredAt = answeredAt;
    }

    public int getId() {
        return id;
    }

    public SCMember getScId() {
        return scId;
    }

    public Byte getStatus() {
        return status;
    }

    public String getReply() {
        return reply;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScId(SCMember scId) {
        this.scId = scId;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getAnsweredAt() {
        return answeredAt;
    }

    public void setAnsweredAt(Date answeredAt) {
        this.answeredAt = answeredAt;
    }
}
