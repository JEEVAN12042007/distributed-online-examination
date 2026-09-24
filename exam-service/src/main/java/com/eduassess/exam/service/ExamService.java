package com.eduassess.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eduassess.exam.entity.Exam;
import com.eduassess.exam.entity.Question;
import com.eduassess.exam.repository.ExamRepository;
import com.eduassess.exam.repository.QuestionRepository;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    public ExamService(
            ExamRepository examRepository,
            QuestionRepository questionRepository) {

        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestions(Long examId) {
        return questionRepository.findByExamExamId(examId);
    }
}