package com.jk.servlet;

import com.jk.pojo.Order;
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
 * @create 2020-10-09 19:57
 */
public class OrderManagerServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // 1、查出所有订单
        List<Order> orders = orderService.getAllOrders();
        // 2、放到域中，转发来到页面
        req.setAttribute("orders",orders);
        // 3、转发到pages/manager/order_manager.jsp
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    /**
     * 处理发货请求
     * @param
     * @param
     * @throws ServletException
     * @throws IOException
     */
    protected void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(request, response);
        //1、封装要发货的订单
//        Order order = WebUtils.copyParamToBean(req, new Order());
        String orderId = req.getParameter("orderId");
        //2、发货操作
        orderService.send(orderId);
        //3、回到页面
        resp.sendRedirect(req.getContextPath()+"/orderManagerServlet?action=showAll");
    }

}
