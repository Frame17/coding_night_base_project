package ua.edu.ukma.e_oss.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "Answer")
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "type", nullable = false)
    private byte type;

    @NotNull
    @Column(name = "answered_at", nullable = false)
    private Date answeredAt;
}
