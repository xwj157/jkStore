package com.jk.service.impl;

import com.jk.dao.JKDao;
import com.jk.dao.OrderDao;
import com.jk.dao.OrderItemDao;
import com.jk.dao.impl.JKDaoImpl;
import com.jk.dao.impl.OrderDaoImpl;
import com.jk.dao.impl.OrderItemDaoImpl;
import com.jk.pojo.*;
import com.jk.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xwj157
 * @create 2020-08-15 21:42
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private JKDao jkDao = new JKDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
            JK jk = jkDao.queryJKById(cartItem.getId());
            jk.setSales(jk.getSales() + cartItem.getCount());
            jk.setStock(jk.getStock() - cartItem.getCount());
            jkDao.updateJK(jk);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> getMyOrders(User user) {
        return orderDao.getMyOrders(user);
    }

    /**
     * 获取所有订单
     *
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    /**
     * 确认收货
     *
     * @param order
     */



    /**
     * 发货
     *
     * @param
     */
    @Override
    public void send(String orderId) {
        orderDao.updateStatus(1,orderId);
    }

    @Override
    public void receive(String orderId) {
        orderDao.updateStatus(2,orderId);
    }

    /**
     * 订单详情
     *
     * @param
     * @return
     */
    @Override
    public List<OrderItem> getOrderDetails(String orderId) {
        return orderItemDao.getOrderDetailsByOrderId(orderId);
    }
}