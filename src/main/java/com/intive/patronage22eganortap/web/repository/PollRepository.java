package com.intive.patronage22eganortap.web.repository;

import com.intive.patronage22eganortap.web.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    @Override
    List<Poll> findAll();
}
