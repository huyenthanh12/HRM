package com.example.HRM.controllers.user.Exception;

import com.example.HRM.shared.ResponseError;
import com.example.HRM.shared.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return ResponseError.buildResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }
}
