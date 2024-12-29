package com.Dhiraj.Models;

import com.Dhiraj.Domain.VerificationType;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
