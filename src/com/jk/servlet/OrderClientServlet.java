package com.jk.servlet;

import com.jk.pojo.Cart;
import com.jk.pojo.Order;
import com.jk.pojo.OrderItem;
import com.jk.pojo.User;
import com.jk.service.OrderService;
import com.jk.service.impl.OrderServiceImpl;
import com.jk.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-15 21:57
 */
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

//        req.setAttribute("orderId",orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doPost(request, response);
        // 1、获取到当前用户
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        // 2、查出对应的订单
        List<Order> myOrders = orderService.getMyOrders(loginUser);
        // 3、放在域中转发到页面进行显示
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
