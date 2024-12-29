package com.Dhiraj.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String error;
    private String message;
    private LocalDateTime timestamp;
}
