package com.jk.dao.impl;

import com.jk.dao.OrderDao;
import com.jk.pojo.Order;

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
}
