package com.Dhiraj.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.VerificationCode;

public interface VerificationService {

    VerificationCode sendVerificationOTP(User user, VerificationType verificationType);

    VerificationCode findVerificationById(Long id) throws Exception;

    VerificationCode findUsersVerification(User user) throws Exception;

    Boolean VerifyOtp(String opt, VerificationCode verificationCode);

    void deleteVerification(VerificationCode verificationCode);
}
