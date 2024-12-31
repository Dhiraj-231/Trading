package com.Dhiraj.Service;

import com.Dhiraj.Domain.OrderType;
import com.Dhiraj.Models.Coin;
import com.Dhiraj.Models.Order;
import com.Dhiraj.Models.OrderItem;
import com.Dhiraj.Models.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId);

    List<Order> getAllOrdersForUser(Long userId, String orderType, String assetSymbol);

    void cancelOrder(Long orderId);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;


}
