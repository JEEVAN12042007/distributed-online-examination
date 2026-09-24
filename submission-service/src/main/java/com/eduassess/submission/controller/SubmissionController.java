package com.eduassess.submission.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduassess.submission.entity.Submission;
import com.eduassess.submission.service.SubmissionService;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(
            SubmissionService submissionService) {

        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<Submission> submit(
            @RequestBody Submission submission) {

        return ResponseEntity.ok(
                submissionService.submit(submission)
        );
    }

    @GetMapping
    public ResponseEntity<List<Submission>> getAll() {

        return ResponseEntity.ok(
                submissionService.getAllSubmissions()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                submissionService.getSubmission(id)
        );
    }
}