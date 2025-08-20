package com.example.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private  String apiPath;

    private HttpStatus errorCodeString;

    private int errorCode;

    private  String errorMessage;

    private LocalDateTime errorTime;
}
