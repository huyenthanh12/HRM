package com.example.HRM.shared;

import com.example.HRM.shared.models.ApiError;
import org.springframework.http.ResponseEntity;

public class ResponseError {
    public static ResponseEntity<Object> buildResponseError(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

