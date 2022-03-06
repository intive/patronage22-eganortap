package com.intive.patronage22eganortap.web.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_answer_gen")
    @SequenceGenerator(name = "user_answer_gen", sequenceName = "user_answer_seq")
    @Column(name = "PK_id", updatable = false, nullable = false)
    private Long id;

    private String sessionId;

    @ManyToOne
    @JoinColumn(name = "FK_Question_id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "FK_Possible_answers_id")
    private PossibleAnswer possibleAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UserAnswer userAnswer = (UserAnswer) o;
        return id != null && this.id.equals(userAnswer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
