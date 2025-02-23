package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Repository.ForgotPasswordRepository;
import org.springframework.stereotype.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Models.ForgotPasswordToken;
import com.Dhiraj.Models.User;
import com.Dhiraj.Service.ForgotPasswordService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    private final ForgotPasswordRepository forgotPasswordRepository;
    @Override
    public ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType,
            String sendTo) {
        ForgotPasswordToken forgotPasswordToken=new ForgotPasswordToken();
        forgotPasswordToken.setUser(user);
        forgotPasswordToken.setId(id);
        forgotPasswordToken.setOtp(otp);
        forgotPasswordToken.setVerificationType(verificationType);
        forgotPasswordToken.setSendTo(sendTo);

        return forgotPasswordRepository.save(forgotPasswordToken);
    }

    @Override
    public void deleteToken(ForgotPasswordToken token) {
        forgotPasswordRepository.delete(token);
    }

    @Override
    public ForgotPasswordToken findById(String id) {
        Optional<ForgotPasswordToken> opt=forgotPasswordRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public ForgotPasswordToken findByUser(Long userId) {
        return forgotPasswordRepository.findByUserId(userId);
    }

    @Override
    public boolean verifyToken(ForgotPasswordToken token, String otp) {
        return token.getOtp().equals(otp);
    }

}
