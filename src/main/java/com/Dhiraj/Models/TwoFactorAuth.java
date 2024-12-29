package com.Dhiraj.Models;

import com.Dhiraj.Domain.VerificationType;

import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
