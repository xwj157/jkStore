package com.jk.dao.impl;

import com.jk.dao.OrderDao;
import com.jk.pojo.Order;
import com.jk.pojo.User;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-15 21:22
 */
public class OrderDaoImpl extends BaseDAO implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    /**
     * 查出某个用户的所有订单
     *
     * @param user
     * @return
     */
    @Override
    public List<Order> getMyOrders(User user) {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where `user_id` = ?";
        return queryForList(Order.class,sql,user.getId());
    }

    /**
     * 查出所有订单。给管理员使用
     *
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order ";
        return queryForList(Order.class,sql);
    }

    /**
     * 修改订单状态
     *
     * @param
     * @return
     */
    @Override
    public int updateStatus(int status,String orderId) {
        String sql = "update t_order set `status` = ? where `order_id` = ?";
        return update(sql,status,orderId);
    }
}
