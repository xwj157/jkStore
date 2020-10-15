package com.jk.service;

import com.jk.pojo.Cart;
import com.jk.pojo.Order;
import com.jk.pojo.OrderItem;
import com.jk.pojo.User;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-15 21:41
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);

    List<Order> getMyOrders(User user);

    List<Order> getAllOrders();

    void send(String orderId);

    void receive(String orderId);

    List<OrderItem> getOrderDetails(String orderId);

}
