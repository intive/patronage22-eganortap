package com.intive.patronage22eganortap.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = 6102598465577178230L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_gen")
    @SequenceGenerator(name = "question_gen", sequenceName = "question_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_id")
    private Poll poll;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", orphanRemoval = true)
    private Set<UserAnswer> userAnswers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", orphanRemoval = true)
    private Set<PossibleAnswer> possibleAnswers;


    @Override
    public boolean equals(Object o) {
        if (Objects.equals(this, o)) return true;
        if (Objects.isNull(o) || !this.getClass().equals(o.getClass())) return false;
        Question question = (Question) o;
        return !Objects.isNull(this.id) && this.id.equals(question.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) * 17;
    }
}
