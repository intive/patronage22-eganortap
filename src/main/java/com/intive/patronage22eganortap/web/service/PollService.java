package com.intive.patronage22eganortap.web.service;


import com.intive.patronage22eganortap.web.domain.*;
import com.intive.patronage22eganortap.web.mapper.UserAnswerMapper;
import com.intive.patronage22eganortap.web.repository.PollRepository;
import com.intive.patronage22eganortap.web.repository.QuestionRepository;
import com.intive.patronage22eganortap.web.repository.UserAnswerRepository;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
@Transactional
public class PollService {

    private final PollRepository pollRepository;

    public Collection<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPoll(long pollId){
        return pollRepository.findById(pollId);
    }

    public void savePoll (final Poll poll) {
        pollRepository.save(poll);
    }

    public void deletePoll (Long pollId) throws NoSuchElementException {
        if (pollRepository.findById(pollId).isPresent()) {
            pollRepository.deleteById(pollId);
        } else {
            throw new NoSuchElementException ();
        }
    }

    public void updateAnswers(Long pollId, List<UserAnswer> answers) throws NoSuchElementException{
        Poll poll = pollRepository.findById(pollId).orElseThrow(NoSuchElementException::new);

        poll.getQuestions().stream()
                .forEach(question -> {
                    answers.stream()
                            .filter(answer -> answer.getQuestion().getId().equals(question.getId()))
                            .forEach(answer -> question.getUserAnswers().add(answer));
                });
    }
}
