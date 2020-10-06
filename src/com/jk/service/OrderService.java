package com.jk.service;

import com.jk.pojo.Cart;

/**
 * @author xwj157
 * @create 2020-08-15 21:41
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
