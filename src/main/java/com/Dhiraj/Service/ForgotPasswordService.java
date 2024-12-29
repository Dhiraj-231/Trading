package com.Dhiraj.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Models.ForgotPasswordToken;
import com.Dhiraj.Models.User;

public interface ForgotPasswordService {
    ForgotPasswordToken createToken(User user, String id, String otp,
            VerificationType verificationType, String sendTo);

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);

    boolean verifyToken(ForgotPasswordToken token, String otp);
}
