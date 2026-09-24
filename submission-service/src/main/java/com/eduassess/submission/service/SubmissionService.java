package com.eduassess.submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eduassess.submission.client.EvaluationClient;
import com.eduassess.submission.dto.EvaluationRequest;
import com.eduassess.submission.entity.Submission;
import com.eduassess.submission.repository.SubmissionRepository;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final EvaluationClient evaluationClient;

    public SubmissionService(
            SubmissionRepository submissionRepository,
            EvaluationClient evaluationClient) {

        this.submissionRepository = submissionRepository;
        this.evaluationClient = evaluationClient;
    }

    public Submission submit(Submission submission) {

        Submission saved =
                submissionRepository.save(submission);

        EvaluationRequest request =
                new EvaluationRequest();

        request.setSubmissionId(saved.getSubmissionId());
        request.setExamId(saved.getExamId());
        request.setStudentId(saved.getStudentId());
        request.setAnswers(saved.getAnswers());

        evaluationClient.evaluate(request);

        return saved;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Submission getSubmission(Long id) {
        return submissionRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                        "Submission not found"
                    )
                );
    }
}