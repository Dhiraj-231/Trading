package com.Dhiraj.Service.ServiceImp;

import org.springframework.stereotype.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Models.ForgotPasswordToken;
import com.Dhiraj.Models.User;
import com.Dhiraj.Service.ForgotPasswordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    @Override
    public ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType,
            String sendTo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteToken(ForgotPasswordToken token) {
        // TODO Auto-generated method stub

    }

    @Override
    public ForgotPasswordToken findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ForgotPasswordToken findByUser(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean verifyToken(ForgotPasswordToken token, String otp) {
        // TODO Auto-generated method stub
        return false;
    }

}
