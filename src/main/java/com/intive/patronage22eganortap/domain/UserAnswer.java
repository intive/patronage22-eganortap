package com.intive.patronage22eganortap.domain;

import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
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
    @Type(type = "uuid-char")
    private UUID sessionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "possible_answer_id")
    private PossibleAnswer possibleAnswer;

    @Override
    public boolean equals(Object o) {
        if (Objects.equals(this, o)) return true;
        if (Objects.isNull(o) || !this.getClass().equals(o.getClass())) return false;
        UserAnswer userAnswer = (UserAnswer) o;
        return !Objects.isNull(this.id) && this.id.equals(userAnswer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) * 19;
    }
}
