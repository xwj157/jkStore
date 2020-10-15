package com.jk.servlet;

import com.jk.pojo.Cart;
import com.jk.pojo.Order;
import com.jk.pojo.OrderItem;
import com.jk.pojo.User;
import com.jk.service.OrderService;
import com.jk.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderClientServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");

        if(loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        List<Order> myOrders = orderService.getMyOrders(loginUser);
        req.setAttribute("orders", myOrders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void orderDetails(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.getOrderDetails(orderId);
        req.getSession().setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/order/order_details.jsp").forward(req, resp);
    }

    protected void receive(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receive(orderId);
        resp.sendRedirect(req.getContextPath()+"/orderClientServlet?action=showAll");
    }
}
