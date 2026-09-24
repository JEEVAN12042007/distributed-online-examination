package com.eduassess.evaluation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduassess.evaluation.entity.Evaluation;

public interface EvaluationRepository
        extends JpaRepository<Evaluation, Long> {

    Optional<Evaluation> findBySubmissionId(Long submissionId);
}