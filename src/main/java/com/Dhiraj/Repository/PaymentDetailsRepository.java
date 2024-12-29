package com.Dhiraj.Repository;

import com.Dhiraj.Models.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long> {
    PaymentDetails getPaymentDetailsByUserId(Long userId);
}
