package com.Dhiraj.Models;

import com.Dhiraj.Domain.WithdrawalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private WithdrawalStatus status;
    private Long amount;

    @ManyToOne
    private User user;

    private LocalDateTime date;
}
