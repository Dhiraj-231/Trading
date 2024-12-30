package com.Dhiraj.Service.ServiceImp;

import com.Dhiraj.Repository.VerificationRepository;
import com.Dhiraj.Utils.OtpUtils;
import org.springframework.stereotype.Service;

import com.Dhiraj.Domain.VerificationType;
import com.Dhiraj.Models.User;
import com.Dhiraj.Models.VerificationCode;
import com.Dhiraj.Service.VerificationService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerificationServiceImp implements VerificationService {
    private final VerificationRepository verificationRepository;

    @Override
    public Boolean VerifyOtp(String opt, VerificationCode verificationCode) {
        return opt.equals(verificationCode.getOtp());
    }

    @Override
    public void deleteVerification(VerificationCode verificationCode) {
        verificationRepository.delete(verificationCode);
    }

    @Override
    public VerificationCode findUsersVerification(User user) throws Exception {
        return verificationRepository.findByUserId(user.getId());
    }

    @Override
    public VerificationCode findVerificationById(Long id) throws Exception {
        Optional<VerificationCode> verificationCodeOptional=verificationRepository.findById(id);
        if(verificationCodeOptional.isEmpty()) throw new Exception("verification not found..");
        return verificationCodeOptional.get();
    }

    @Override
    public VerificationCode sendVerificationOTP(User user, VerificationType verificationType) {
        VerificationCode verificationCode = new VerificationCode();

        verificationCode.setOtp(OtpUtils.generateOTP());
        verificationCode.setUser(user);
        verificationCode.setVerificationType(verificationType);

        return verificationRepository.save(verificationCode);
    }

}
