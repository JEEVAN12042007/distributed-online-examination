package com.eduassess.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduassess.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}