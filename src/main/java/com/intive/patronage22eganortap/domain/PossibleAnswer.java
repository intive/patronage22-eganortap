package com.intive.patronage22eganortap.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PossibleAnswer implements Serializable {

    @Serial
    private static final long serialVersionUID = -8313903398010184420L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "possible_answer_gen")
    @SequenceGenerator(name = "possible_answer_gen", sequenceName = "possible_answer_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Override
    public boolean equals(Object o) {
        if (Objects.equals(this, o)) return true;
        if (Objects.isNull(o) || !this.getClass().equals(o.getClass())) return false;
        PossibleAnswer possibleAnswer = (PossibleAnswer) o;
        return !Objects.isNull(this.id) && this.id.equals(possibleAnswer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
