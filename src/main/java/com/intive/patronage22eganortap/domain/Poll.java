package com.intive.patronage22eganortap.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

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
    @SequenceGenerator(name = "poll_gen", sequenceName = "patronage_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    @Size(max = 25)
    @NotBlank
    private String name;
    @Size(max = 50)
    @NotBlank
    private String description;
    @Email
    @NotBlank
    private String email;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime creationDate;
    @NotNull
    @Min(0)
    private int timer;
    private LocalDateTime startDate;
    @URL
    @NotBlank
    private String link;
    @Enumerated(EnumType.STRING)
    @NotNull
    private PollStatus status;
    private boolean isPublic;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "poll", orphanRemoval = true)
    @Size(max = 25)
    private Set<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poll poll)) return false;
        return Objects.nonNull(this.id) && this.id.equals(poll.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) * PrimeConstants.POLL_HASH_PRIME;
    }
}
