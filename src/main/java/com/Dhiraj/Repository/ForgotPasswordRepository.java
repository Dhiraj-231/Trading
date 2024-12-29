package com.Dhiraj.Repository;

import com.Dhiraj.Models.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken,Long> {
    ForgotPasswordToken findByUserId(Long userId);
}
