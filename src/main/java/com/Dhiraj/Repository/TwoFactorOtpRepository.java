package com.Dhiraj.Repository;

import com.Dhiraj.Models.TwoFactorOTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorOtpRepository extends JpaRepository<TwoFactorOTP,String> {
}
