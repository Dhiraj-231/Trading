package com.Dhiraj.Request;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    
    private String password;
    private String otp;
}
