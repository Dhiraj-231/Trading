package com.Dhiraj.Service.ServiceImp;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Dhiraj.Models.TwoFactorOTP;
import com.Dhiraj.Models.User;
import com.Dhiraj.Repository.TwoFactorOtpRepository;
import com.Dhiraj.Service.TwoFactorOtpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TwoFactorOtpServiceImp implements TwoFactorOtpService {
    private final TwoFactorOtpRepository twoFactorOtpRepository;

    @Override
    public TwoFactorOTP createTwoFactorOTP(User user, String otp, String jwt) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        TwoFactorOTP twoFactorOTP = new TwoFactorOTP();
        twoFactorOTP.setId(id);
        twoFactorOTP.setUser(user);
        twoFactorOTP.setOtp(otp);
        twoFactorOTP.setJwt(jwt);
        return twoFactorOtpRepository.save(twoFactorOTP);
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP) {
        twoFactorOtpRepository.delete(twoFactorOTP);
    }

    @Override
    public TwoFactorOTP findById(String id) {
        Optional<TwoFactorOTP> twoFactorOtp = twoFactorOtpRepository.findById(id);
        return twoFactorOtp.orElse(null);
    }

    @Override
    public TwoFactorOTP findByUserId(Long userId) {
        return twoFactorOtpRepository.findByUserId(userId);
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP, String otp) {
        return twoFactorOTP.getOtp().equals(otp);
    }

}
