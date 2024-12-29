package com.Dhiraj.Repository;

import com.Dhiraj.Models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
