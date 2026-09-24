package com.eduassess.evaluation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduassess.evaluation.dto.EvaluationRequest;
import com.eduassess.evaluation.entity.Evaluation;
import com.eduassess.evaluation.service.EvaluationService;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(
            EvaluationService evaluationService) {

        this.evaluationService = evaluationService;
    }

    @PostMapping
    public ResponseEntity<Evaluation> evaluate(
            @RequestBody EvaluationRequest request) {

        return ResponseEntity.ok(
                evaluationService.evaluate(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluation(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                evaluationService.getEvaluation(id)
        );
    }
}