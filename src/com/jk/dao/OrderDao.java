package com.jk.dao;

import com.jk.pojo.Order;
import com.jk.pojo.User;

import java.util.List;

public interface OrderDao {
    public int saveOrder(Order order);

    public List<Order> getAllOrders();

    public List<Order> getMyOrders(User user);

    public int updateStatus(int status,String orderId);
}
