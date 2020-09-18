package com.example.HRM.controllers.role.exception;

import com.example.HRM.shared.ResponseError;
import com.example.HRM.shared.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoleExceptionController {
    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<Object> exception(RoleNotFoundException exception) {
        return ResponseError.buildResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }
}
