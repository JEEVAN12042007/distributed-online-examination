package com.eduassess.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduassess.exam.entity.Exam;
import com.eduassess.exam.entity.Question;
import com.eduassess.exam.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(
            @RequestBody Exam exam) {

        return ResponseEntity.ok(
                examService.createExam(exam)
        );
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {

        return ResponseEntity.ok(
                examService.getAllExams()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExam(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                examService.getExamById(id)
        );
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> addQuestion(
            @RequestBody Question question) {

        return ResponseEntity.ok(
                examService.addQuestion(question)
        );
    }

    @GetMapping("/{examId}/questions")
    public ResponseEntity<List<Question>> getQuestions(
            @PathVariable Long examId) {

        return ResponseEntity.ok(
                examService.getQuestions(examId)
        );
    }
}