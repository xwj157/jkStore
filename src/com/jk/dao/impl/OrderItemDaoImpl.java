package com.jk.dao.impl;

import com.jk.dao.OrderItemDao;
import com.jk.pojo.OrderItem;

/**
 * @author xwj157
 * @create 2020-08-15 21:23
 */
public class OrderItemDaoImpl extends BaseDAO implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
