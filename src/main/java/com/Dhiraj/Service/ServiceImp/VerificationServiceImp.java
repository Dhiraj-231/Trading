package com.Dhiraj.Service.ServiceImp;

import org.springframework.stereotype.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.VerificationCode;
import com.Dhiraj.Service.VerificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationServiceImp implements VerificationService {

    @Override
    public Boolean VerifyOtp(String opt, VerificationCode verificationCode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteVerification(VerificationCode verificationCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public VerificationCode findUsersVerification(User user) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VerificationCode findVerificationById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VerificationCode sendVerificationOTP(User user, VerificationType verificationType) {
        // TODO Auto-generated method stub
        return null;
    }

}
