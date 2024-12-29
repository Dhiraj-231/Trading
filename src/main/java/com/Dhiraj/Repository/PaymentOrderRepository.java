package com.Dhiraj.Repository;

import com.Dhiraj.Models.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long> {
}
