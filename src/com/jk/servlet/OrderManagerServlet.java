package com.jk.servlet;

import com.jk.pojo.Order;
import com.jk.service.OrderService;
import com.jk.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderManagerServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.getAllOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    protected void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.send(orderId);
        resp.sendRedirect(req.getContextPath()+"/orderManagerServlet?action=showAll");
    }

}
