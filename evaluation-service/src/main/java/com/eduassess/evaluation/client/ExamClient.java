package com.eduassess.evaluation.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eduassess.evaluation.dto.QuestionResponse;

@FeignClient(name = "exam-service")
public interface ExamClient {

    @GetMapping("/exams/{examId}/questions")
    List<QuestionResponse> getQuestions(
            @PathVariable Long examId);
}