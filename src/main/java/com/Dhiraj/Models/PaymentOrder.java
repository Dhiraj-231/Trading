package com.Dhiraj.Models;

import com.Dhiraj.Domain.PaymentMethod;
import com.Dhiraj.Domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;
    private PaymentOrderStatus status=PaymentOrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    @ManyToOne
    private User user;
}
