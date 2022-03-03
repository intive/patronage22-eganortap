package com.intive.patronage22eganortap.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAnswer implements Serializable {

    @Serial
    private static final long serialVersionUID = -1437565072919849496L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_answer_gen")
    @SequenceGenerator(name = "user_answer_gen", sequenceName = "user_answer_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    @NotNull
    private UUID sessionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "possible_answer_id")
    @NotNull
    private PossibleAnswer possibleAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAnswer userAnswer)) return false;
        return Objects.nonNull(this.id) && this.id.equals(userAnswer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) * 11;
    }
}
