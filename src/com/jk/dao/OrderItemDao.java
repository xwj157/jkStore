package com.jk.dao;

import com.jk.pojo.OrderItem;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-15 21:21
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> getOrderDetailsByOrderId(String orderId);

}
