package com.Dhiraj.Request;

import com.Dhiraj.Domain.VerificationType;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String sendTo;
    private VerificationType verificationType;
}
