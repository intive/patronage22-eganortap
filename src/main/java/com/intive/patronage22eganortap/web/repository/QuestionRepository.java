package com.intive.patronage22eganortap.web.repository;

import com.intive.patronage22eganortap.web.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
