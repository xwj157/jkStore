package com.jk.dao;

import com.jk.pojo.Order;
import com.jk.pojo.User;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-15 21:20
 */
public interface OrderDao {
    public int saveOrder(Order order);


    /**
     * 查出所有订单。给管理员使用
     * @return
     */
    public List<Order> getAllOrders();

    /**
     * 查出某个用户的所有订单
     * @param user
     * @return
     */
    public List<Order> getMyOrders(User user);

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    public int updateStatus(int status,String orderId);
}
