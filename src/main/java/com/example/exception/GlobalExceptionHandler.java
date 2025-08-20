package com.example.exception;

import com.example.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponseDto.builder()
                        .apiPath(request.getDescription(false))
                        .errorCodeString(HttpStatus.NOT_FOUND)
                        .errorCode(HttpStatus.NOT_FOUND.value())
                        .errorMessage(ex.getMessage())
                        .errorTime(LocalDateTime.now())
                        .build()
        );
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorResponseDto.builder()
                        .apiPath(request.getDescription(false))
                        .errorCodeString(HttpStatus.INTERNAL_SERVER_ERROR)
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .errorMessage(ex.getMessage())
                        .errorTime(LocalDateTime.now())
                        .build()
        );
    }
}
