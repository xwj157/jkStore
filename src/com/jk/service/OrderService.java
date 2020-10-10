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
    public String createOrder(Cart cart, Integer userId);

    public List<Order> getMyOrders(User user);

    /**
     * 获取所有订单
     * @return
     */
    public List<Order> getAllOrders();

    /**
     * 发货
     * @param
     */
    public void send(String orderId);

    /**
     * 确认收货
     * @param
     */
    public void receive(String orderId);

    /**
     * 订单详情
     * @param
     * @return
     */
    public List<OrderItem> getOrderDetails(String orderId);

}
