package com.intive.patronage22eganortap.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Poll implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PK_id", updatable = false, nullable = false)
    private Long id;

    private String name;

    private String description;

    private String email;

    private Date creationDate;

    private int timer;

    private Date startDate;

    private String link;

    private String status;

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
