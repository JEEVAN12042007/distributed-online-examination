package com.eduassess.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduassess.exam.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByExamExamId(Long examId);
}