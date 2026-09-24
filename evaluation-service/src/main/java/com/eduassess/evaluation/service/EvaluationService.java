package com.eduassess.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eduassess.evaluation.client.ExamClient;
import com.eduassess.evaluation.dto.EvaluationRequest;
import com.eduassess.evaluation.dto.QuestionResponse;
import com.eduassess.evaluation.entity.Evaluation;
import com.eduassess.evaluation.repository.EvaluationRepository;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final ExamClient examClient;

    public EvaluationService(
            EvaluationRepository evaluationRepository,
            ExamClient examClient) {

        this.evaluationRepository = evaluationRepository;
        this.examClient = examClient;
    }

    public Evaluation evaluate(EvaluationRequest request) {

        List<QuestionResponse> questions =
                examClient.getQuestions(request.getExamId());

        String[] studentAnswers =
                request.getAnswers().split(",");

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {

            if (i < studentAnswers.length) {

                String studentAnswer =
                        studentAnswers[i].trim();

                String correctAnswer =
                        questions.get(i)
                                 .getCorrectAnswer()
                                 .trim();

                if (studentAnswer.equalsIgnoreCase(correctAnswer)) {

                    score += questions.get(i).getMarks();
                }
            }
        }

        String resultStatus =
                score >= 40 ? "PASS" : "FAIL";

        Evaluation evaluation = new Evaluation();

        evaluation.setSubmissionId(
                request.getSubmissionId()
        );

        evaluation.setScore(score);

        evaluation.setResultStatus(resultStatus);

        return evaluationRepository.save(evaluation);
    }

    public Evaluation getEvaluation(Long id) {

        return evaluationRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                        "Evaluation not found"
                    )
                );
    }
}