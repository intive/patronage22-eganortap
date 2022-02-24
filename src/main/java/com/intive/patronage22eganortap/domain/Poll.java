package com.intive.patronage22eganortap.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Poll implements Serializable {

    @Serial
    private static final long serialVersionUID = 2694133040909573689L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poll_gen")
    @SequenceGenerator(name = "poll_gen", sequenceName = "poll_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private String description;
    private String email;
    private LocalDate creationDate;
    private int timer;
    private LocalDate startDate;
    private URL link;
    @Enumerated(EnumType.STRING)
    private PollStatus status;
    private boolean isPublic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poll", orphanRemoval = true)
    private List<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return id != null && this.id.equals(poll.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
