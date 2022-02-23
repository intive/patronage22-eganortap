package com.intive.patronage22eganortap.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PossibleAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "possible_answer_gen")
    @SequenceGenerator(name = "possible_answer_gen", sequenceName = "possible_answer_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PossibleAnswer possibleAnswer = (PossibleAnswer) o;
        return id != null && this.id.equals(possibleAnswer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
