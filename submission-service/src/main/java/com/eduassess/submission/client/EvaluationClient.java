package com.eduassess.submission.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eduassess.submission.dto.EvaluationRequest;

@FeignClient(name = "evaluation-service")
public interface EvaluationClient {

    @PostMapping("/evaluations")
    String evaluate(
            @RequestBody EvaluationRequest request
    );
}