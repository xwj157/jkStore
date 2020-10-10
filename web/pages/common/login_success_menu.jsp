<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${not empty sessionScope.user}">
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临兔姬舍</span>
        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    </c:if>
    <a href="orderClientServlet?action=showAll">我的订单</a>
    <a href="pages/cart/cart.jsp">购物车</a>
    <a href="index.jsp">返回</a>
</div>
